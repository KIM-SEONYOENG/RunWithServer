package com.example.runWith.controller;

import com.example.runWith.domain.DataResponse;
import com.example.runWith.domain.MessageDomain;
import com.example.runWith.domain.TokenDomain;
import com.example.runWith.service.FirebaseCloudMessageService;
import com.example.runWith.service.TokenService;
import com.example.runWith.util.FcmUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/message")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    public TokenController() {
    }

    @PostMapping("/newToken")
    public DataResponse addToken(@RequestParam String id, @RequestParam String newToken){ return tokenService.addToken(id, newToken);}

    @PostMapping("/sendMessage")
    public void pushMessage(@RequestParam String id, @RequestParam String message) throws IOException { tokenService.pushMessage(id, message); }

    @RequestMapping(value = "/fcmtest")
    public @ResponseBody String fcmtest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String tokenId = "";
        String title = "제목!";
        String content = "내용!";

        FcmUtil fcmUtil = new FcmUtil();
        fcmUtil.send_FCM(tokenId, title, content);
        return "test";
    }
}
