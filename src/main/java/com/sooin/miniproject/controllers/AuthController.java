package com.sooin.miniproject.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooin.miniproject.Utils.JwtUtil;
import com.sooin.miniproject.models.User;
import com.sooin.miniproject.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtill;
    
    @PostMapping("/sign-in")
    public String signIn(@RequestBody User user) {

        try {
            User findUser = userService.findUserByUserName(user.getUserName());
            if (findUser != null && findUser.getUserPassword().equals(user.getUserPassword())) {
                return jwtUtill.generateToken(user.getUserName());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
