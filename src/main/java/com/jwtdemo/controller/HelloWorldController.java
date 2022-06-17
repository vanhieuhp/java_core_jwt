package com.jwtdemo.controller;

import com.jwtdemo.model.UserModel;
import com.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String showPage() {
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.createUser(userModel));
    }
}
