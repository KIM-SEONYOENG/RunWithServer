package com.example.runWith.controller;

import com.example.runWith.domain.UserDomain;
import com.example.runWith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
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
    public List<UserDomain> searchUser(@RequestParam("keyword") String keyword) { return userService.searchUser(keyword); }

    @GetMapping("/login")
    public boolean login(@RequestBody UserDomain user) {
        UserDomain userDomain = userService.findUserById(user.getId());
        if(userDomain.getPw().equals(user.getPw()))
            return true;
        return false;
    }
}
