package com.example.runWith.service;

import com.example.runWith.domain.DataResponse;
import com.example.runWith.domain.MessageDomain;
import com.example.runWith.domain.TokenDomain;
import com.example.runWith.mapper.TokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final FirebaseCloudMessageService firebaseCloudMessageService;

    @Autowired
    private TokenMapper tokenDao;

//    public DataResponse addToken2(String newToken) {
//        long result;
//        if(tokenDao.countToken(id) == 0)
//            result = tokenDao.addToken(id, newToken);
//        else
//            result = tokenDao.updateToken(id, newToken);
//
//        DataResponse response = new DataResponse();
//        System.out.println("result = " + result);
//
//        if(result == 1) {
//            response.setResultCode(200);
//            response.setMessage("토큰 저장 성공");
//        } else {
//            response.setResultCode(400);
//            response.setMessage("토큰 저장 실패");
//        }
//        return response;
//    }

    public DataResponse updateIdByToken(String id, String token) {
        long result;
        if(tokenDao.countToken(token) == 1)
            result = tokenDao.updateIdByToken(id, token);
        else
            result = 0;
        DataResponse response = new DataResponse();
        if(result != 0) {
            response.setResultCode(200);
            response.setMessage("토큰 저장 성공");
        } else {
            response.setResultCode(400);
            response.setMessage("토큰 저장 실패");
        }
        return response;
    }

    public DataResponse updateTokenById(String id, String token) {
        long result;
        if(tokenDao.countId(id) == 1)
            result = tokenDao.updateTokenById(id, token);
        else
            result = 0;
        DataResponse response = new DataResponse();
        if(result != 0) {
            response.setResultCode(200);
            response.setMessage("토큰 저장 성공");
        } else {
            response.setResultCode(400);
            response.setMessage("토큰 저장 실패");
        }
        return response;
    }

    public DataResponse addToken(String newToken) {
        System.out.println("함수 들어옴");
        long result;
        if(tokenDao.countToken(newToken) == 0)
            result = tokenDao.addToken(newToken);

        else {
            result = 0;
            System.out.println("countToken이 0이 아님");
        }

        DataResponse response = new DataResponse();
        System.out.println("result = " + result);

        if(result != 0) {
            response.setResultCode(200);
            response.setMessage("토큰 저장 성공");
        } else {
            response.setResultCode(400);
            response.setMessage("토큰 저장 실패");
        }
        return response;
    }

    public void pushMessage(String id, String message) throws IOException {
        String token = tokenDao.findToken(id);

        System.out.println(token + " " + message);

        firebaseCloudMessageService.sendMessageTo(token, id, message);
    }
}
