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

    public DataResponse addToken(TokenDomain newToken) {
        TokenDomain result = null;
        if(tokenDao.countToken(newToken.getId()) == 0)
            result = tokenDao.addToken(newToken);
        else
            result = tokenDao.updateRecord(newToken);

        DataResponse response = new DataResponse();
        if(result == null) {
            response.setResultCode(200);
            response.setMessage("토큰 저장 성공");
        } else {
            response.setResultCode(400);
            response.setMessage("토큰 저장 실패");
        }
        return response;
    }

    public void pushMessage(MessageDomain message) throws IOException {
        String token = tokenDao.findToken(message.getId()).getNum();

        System.out.println(token + " " + message.getMsg());

        firebaseCloudMessageService.sendMessageTo(token, message.getId(), message.getMsg());
    }
}
