package com.example.runWith.controller;

import com.example.runWith.domain.LoginResponse;
import com.example.runWith.domain.UserDomain;
import com.example.runWith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDomain> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/findPw")
    public HashMap<String, String> findPw(@RequestParam("id") String id) {
        HashMap<String, String> password = new HashMap<>();
        password.put("pw", "1234");
        return password;
    }

    @GetMapping("/searchUser")
    public List<UserDomain> search(@RequestParam("keyword") String keyword) { return userService.searchUser(keyword); }

    @GetMapping("/login")
    public LoginResponse login(@RequestParam("id") String id, @RequestParam("pw") String pw) { return userService.findUserById(id, pw); }
}
