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
        int result = userDao.idCheck(id);
        System.out.println("idCheck result = " + result);
        if(result == 0) {
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
        System.out.println("addUser result =" + resultCode);
        if(resultCode == 300) {
            System.out.println("addUser duplicated");
            return new DataResponse(300, "중복된 아이디입니다");
        }
        userDao.addUser(id);
        return new DataResponse(200, "회원 가입 성공");
    }

    public UserDomain findUserById(String id) {
        return userDao.findUserById(id);
    }

    public DataResponse addMember(String id, String memberId) {
        long result = 0;



//        if(userDao.countToken(id) == 0)
//            result = tokenDao.addToken(id, newToken);
//        else
//            result = tokenDao.updateToken(id, newToken);

        DataResponse response = new DataResponse();
        System.out.println("result = " + result);

        if(result == 1) {
            response.setResultCode(200);
            response.setMessage("토큰 저장 성공");
        } else {
            response.setResultCode(400);
            response.setMessage("토큰 저장 실패");
        }
        return response;
    }
}
