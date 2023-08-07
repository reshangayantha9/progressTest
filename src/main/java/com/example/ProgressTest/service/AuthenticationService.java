package com.example.ProgressTest.service;

import com.example.ProgressTest.Authentication.AuthenticationRequest;
import com.example.ProgressTest.Authentication.AuthenticationResponse;
import com.example.ProgressTest.Authentication.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
