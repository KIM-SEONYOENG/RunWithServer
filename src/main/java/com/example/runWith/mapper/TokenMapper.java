package com.example.runWith.mapper;

import com.example.runWith.domain.TokenDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TokenMapper {
    public int countToken(@Param("id") String id);
    public TokenDomain addToken(@Param("id") String id, @Param("newToken") String newToken);
    public TokenDomain updateRecord(@Param("id") String id, @Param("newToken") String newToken);
    public TokenDomain findToken(@Param("id") String id);
}
