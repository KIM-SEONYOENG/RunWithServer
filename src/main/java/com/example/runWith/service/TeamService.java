package com.example.runWith.service;

import com.example.runWith.domain.TeamDomain;
import com.example.runWith.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamMapper teamDao;

    public String findTeamMember(String id) {
        TeamDomain team = teamDao.findTeamMember(id);
        if(team.getId_f().equals(id))
            return team.getId_s();
        else
            return team.getId_f();
    }
}
