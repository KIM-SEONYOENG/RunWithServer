package com.example.runWith.service;

import com.example.runWith.domain.RecordDomain;
import com.example.runWith.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordDao;

    @Autowired
    private TeamService teamService;

    public List<RecordDomain> findAllRecord() { return recordDao.findAllRecord(); }
    public RecordDomain findRecord (String id, String day) { return recordDao.findRecord(id, day); }

    public void addRecord(RecordDomain newRecord) {
        if(recordDao.findRecord(newRecord.getId(), newRecord.getDay()) != null)
            recordDao.updateRecord(newRecord);
        else
            recordDao.addRecord(newRecord);
    }

    public RecordDomain findMemberRecord(String id) {
        String memberId = teamService.findTeamMember(id);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String day = format.format(now);

        return recordDao.findRecord(memberId, day);
    }
}
