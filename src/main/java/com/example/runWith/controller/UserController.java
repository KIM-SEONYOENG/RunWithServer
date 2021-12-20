package com.example.runWith.controller;

import com.example.runWith.domain.UserDomain;
import com.example.runWith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public boolean login(@RequestBody UserDomain user) {
        UserDomain userDomain = userService.findUserById(user.getId());
        if(userDomain.getPw().equals(user.getPw()))
            return true;
        return false;
    }

    @GetMapping("/findUser")
    public List<UserDomain> findUser(@RequestParam String keyword) { return userService.findUser(keyword); }
}
