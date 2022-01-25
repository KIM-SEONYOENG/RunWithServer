package com.example.runWith.mapper;

import com.example.runWith.domain.RecordDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    public List<RecordDomain> findAllRecord();
    public RecordDomain findRecord(@Param("id") String id, @Param("day") String day);
    public void addRecord(@Param("newRecord") RecordDomain newRecord);
    public void updateRecord(@Param("newRecord") RecordDomain newRecord);
    public List<RecordDomain> showRecord(@Param("id") String id);
}
