package com.example.ProgressTest.service.serviceImpl;


import com.example.ProgressTest.entity.User;
import com.example.ProgressTest.repository.UserRepository;
import com.example.ProgressTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

}
