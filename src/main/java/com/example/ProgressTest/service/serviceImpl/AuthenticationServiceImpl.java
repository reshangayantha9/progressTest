package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.Authentication.AuthenticationRequest;
import com.example.ProgressTest.Authentication.AuthenticationResponse;
import com.example.ProgressTest.Authentication.RegisterRequest;
import com.example.ProgressTest.config.JwtService;
import com.example.ProgressTest.entity.User;
import com.example.ProgressTest.repository.UserRepository;
import com.example.ProgressTest.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        try {
            User user =new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            repository.save(user);
            var jwtToken=jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User account has been successfully created")
                    .build();
        }catch (Exception e){
            return AuthenticationResponse.builder()
                    .message(e.toString())
                    .build();
        }

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()

                    )
            );

            User user=repository.findByEmail(request.getEmail())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User account has been successfully Authenticated")
                    .build();
        }catch (Exception e){
            return AuthenticationResponse.builder()
                    .message(e.toString())
                    .build();
        }

    }
}
