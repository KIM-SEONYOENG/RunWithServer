package com.example.runWith.controller;

import com.example.runWith.domain.DataResponse;
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

    @PostMapping("/add")
    public DataResponse addUser(@RequestParam("id") String id) {
        DataResponse response = userService.addUser(id);
        System.out.println("userController addUser resultCode = " + response.getResultCode());
        return response;
    }

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

    @GetMapping("/findDuplicateId")
    public HashMap<String, Boolean> findDuplicateId(@RequestParam("id") String id) {
        return userService.findDuplicateId(id);
    }

    @GetMapping("/idCheck")
    public DataResponse idCheck(@RequestParam("id") String id) {
        return userService.idCheck(id);
    }

    @GetMapping("/findUserById")
    public UserDomain findUserById(@RequestParam("id") String id) {
        return userService.findUserById(id);
    }

    @PostMapping("/addMember")
    public DataResponse addMember(@RequestParam String id, @RequestParam String memberId){ return userService.addMember(id, memberId);}
}
