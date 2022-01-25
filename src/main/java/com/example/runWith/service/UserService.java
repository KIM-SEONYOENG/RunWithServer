package com.example.runWith.service;

import com.example.runWith.domain.LoginResponse;
import com.example.runWith.domain.Response;
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
    public LoginResponse findUserById(String id, String pw) {
        LoginResponse response = new LoginResponse();
        UserDomain user = userDao.findUserById(id);
        if(user == null) {
            response.setResultCode(400);
            response.setMessage("존재하지 않는 회원입니다");
            return response;
        }

        if(user.getId().equals(id) && user.getPw().equals(pw)) {
            response.setResultCode(200);
            response.setMessage("로그인 성공!");
            return response;
        }

        response.setResultCode(300);
        response.setMessage("아이디 혹은 비밀번호를 확인해주세요");
        return response;
    }
    public List<UserDomain> searchUser(String keyword) { return userDao.searchUser(keyword); }
}
