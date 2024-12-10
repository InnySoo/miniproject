package com.sooin.miniproject.services;

import org.springframework.stereotype.Service;

import com.sooin.miniproject.mappers.UserMapper;
import com.sooin.miniproject.models.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User findUserByUserName(String userName) {
        User user = userMapper.findByUserName(userName);
        if (user == null) {
            throw new RuntimeException("User not found: " + userName);
        }
        return user;
    }
    
}
