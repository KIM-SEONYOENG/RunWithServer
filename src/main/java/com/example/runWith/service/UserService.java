package com.example.runWith.service;

import com.example.runWith.domain.DataResponse;
import com.example.runWith.domain.UserDomain;
import com.example.runWith.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userDao;

    public List<UserDomain> findAllUser() { return userDao.findAllUser(); }
    public DataResponse findUserById(String id, String pw) {
        DataResponse response = new DataResponse();
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

    public HashMap<String, Boolean> findDuplicateId(String id) {
        HashMap<String, Boolean> result = new HashMap<>();
        if(userDao.findUserById(id) == null) {
            result.put("duplicate", true);
        } else {
            result.put("duplicate", false);
        }
        return result;
    }

    public DataResponse idCheck(String id) {
        DataResponse response = new DataResponse();
        if(userDao.idCheck(id) == 0) {
            response.setResultCode(200);
            response.setMessage("아이디 확인 완료");
        }
        else {
            response.setResultCode(300);
            response.setMessage("중복된 아이디입니다.");
        }
        return response;
    }

    public DataResponse addUser(String id) {
        int resultCode = idCheck(id).getResultCode();
        if(resultCode == 300) {
            return new DataResponse(300, "중복된 아이디입니다");
        }
        UserDomain newUser = userDao.addUser(id);
        if(newUser.getId().equals(id)) {
            return new DataResponse(200, "회원 가입 성공");
        } else {
            return new DataResponse(400, "회원 가입 실패");
        }
    }
}
