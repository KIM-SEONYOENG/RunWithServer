package com.example.runWith.service;

import com.example.runWith.domain.TokenDomain;
import com.example.runWith.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private TokenMapper tokenDao;

    public void addToken(TokenDomain newToken) {
        if(tokenDao.countToken(newToken.getId()) == 0)
            tokenDao.addToken(newToken);
        else
            tokenDao.updateRecord(newToken);
    }
}
