package com.example.runWith.mapper;

import com.example.runWith.domain.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDomain> findAllUser();
    public UserDomain findUserById(@Param("id") String id);
    public List<UserDomain> searchUser(@Param("keyword") String keyword);
    public void joinUser(@Param("newUser") UserDomain newUser);
}
