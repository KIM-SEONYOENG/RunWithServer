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

    public List<RecordDomain> findAllRecord() { return recordDao.findAllRecord(); }
    public RecordDomain findRecord (String id, String day) { return recordDao.findRecord(id, day); }

    public void addRecord(RecordDomain newRecord) {
        if(recordDao.findRecord(newRecord.getId(), newRecord.getDay()) != null)
            recordDao.updateRecord(newRecord);
        else
            recordDao.addRecord(newRecord);
    }

    public RecordDomain findMemberRecord(String id) {
        return recordDao.findMemberRecord(id);
    }
}
