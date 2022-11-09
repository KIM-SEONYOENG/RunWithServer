package com.example.runWith.mapper;

import com.example.runWith.domain.TokenDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TokenMapper {
    public int countToken(@Param("token") String token);
    public int countId(@Param("id") String id);
    public long addToken2(@Param("id") String id, @Param("newToken") String newToken);
    public long updateIdByToken(@Param("id") String id, @Param("token") String token);
    public long updateTokenById(@Param("id") String id, @Param("token") String token);
    public long addToken(@Param("newToken") String newToken);
    public String findToken(@Param("id") String id);
}
