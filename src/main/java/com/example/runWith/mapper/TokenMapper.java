package com.example.runWith.mapper;

import com.example.runWith.domain.TokenDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TokenMapper {
    public int countToken(@Param("id") String id);
    public long addToken(@Param("id") String id, @Param("newToken") String newToken);
    public long updateToken(@Param("id") String id, @Param("newToken") String newToken);
    public String findToken(@Param("id") String id);
}
