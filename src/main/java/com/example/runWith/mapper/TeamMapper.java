package com.example.runWith.mapper;

import com.example.runWith.domain.TeamDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamMapper {
    public TeamDomain findTeamMember(@Param("id") String id);
}
