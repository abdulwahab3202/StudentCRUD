package com.kce.controller;

import com.kce.models.Users;
import com.kce.response.CommonResponce;
import com.kce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CommonResponce> register(@RequestBody Users users){
        CommonResponce response = userService.register(users);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }
}