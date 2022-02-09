package com.example.runWith.controller;

import com.example.runWith.domain.DataResponse;
import com.example.runWith.domain.MessageDomain;
import com.example.runWith.domain.TokenDomain;
import com.example.runWith.service.FirebaseCloudMessageService;
import com.example.runWith.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    public TokenController() {
    }

    @PostMapping("/addToken")
    public DataResponse addToken(@RequestBody TokenDomain newToken){ return tokenService.addToken(newToken);}

    @PostMapping("/sendMessage")
    public void pushMessage(@RequestBody MessageDomain message) throws IOException { tokenService.pushMessage(message); }
}
