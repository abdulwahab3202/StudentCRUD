package com.kce.controller;

import com.kce.models.Users;
import com.kce.repository.UserRepository;
import com.kce.response.CommonResponce;
import com.kce.service.JWTService;
import com.kce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;


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