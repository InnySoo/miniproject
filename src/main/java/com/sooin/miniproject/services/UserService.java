package com.sooin.miniproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooin.miniproject.mappers.UserMapper;
import com.sooin.miniproject.models.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Optional<User> getUserById(int userId) {
        return userMapper.findByUserId(userId);
    }

    public Optional<User> getUserByUsername(String userName) {
        return userMapper.findByUserName(userName);
    }
    
}
