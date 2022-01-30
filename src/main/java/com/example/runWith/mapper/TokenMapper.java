package com.example.runWith.mapper;

import com.example.runWith.domain.TokenDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TokenMapper {
    public int countToken(@Param("id") String id);
    public void addToken(@Param("newToken") TokenDomain newToken);
    public void updateRecord(@Param("newToken") TokenDomain newToken);
}
