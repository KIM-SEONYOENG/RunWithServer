package com.example.runWith.service;

import com.example.runWith.domain.UserDomain;
import com.example.runWith.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userDao;

    public List<UserDomain> findAllUser() { return userDao.findAllUser(); }
    public UserDomain findUserById(String id) { return userDao.findUserById(id); }
}
