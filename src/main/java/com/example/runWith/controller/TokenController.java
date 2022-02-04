package com.example.runWith.controller;

import com.example.runWith.domain.DataResponse;
import com.example.runWith.domain.MessageDomain;
import com.example.runWith.domain.TokenDomain;
import com.example.runWith.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/addToken")
    public DataResponse addToken(@RequestBody TokenDomain newToken){ return tokenService.addToken(newToken);}

//    @PostMapping("/sendMessage") : FCM 서버 해서 메세지 전송
}
