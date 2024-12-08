package com.sooin.miniproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooin.miniproject.mappers.UserMapper;
import com.sooin.miniproject.models.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
    
}
