package com.example.ProgressTest.service;

import com.example.ProgressTest.Authentication.AuthenticationRequest;
import com.example.ProgressTest.Authentication.AuthenticationResponse;
import com.example.ProgressTest.Authentication.RegisterRequest;
import com.example.ProgressTest.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String username);

}
