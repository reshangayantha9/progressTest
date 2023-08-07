package com.example.ProgressTest.controller;

import com.example.ProgressTest.Authentication.AuthenticationRequest;
import com.example.ProgressTest.Authentication.AuthenticationResponse;
import com.example.ProgressTest.Authentication.RegisterRequest;
import com.example.ProgressTest.service.AuthenticationService;
import com.example.ProgressTest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse>register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
