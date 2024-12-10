package com.sooin.miniproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sooin.miniproject.Utils.JwtUtil;
import com.sooin.miniproject.models.User;
import com.sooin.miniproject.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping("/")
    public User getSignInUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String userName = jwtUtil.validateToken(token);
        return userService.findUserByUserName(userName);
    }
    
}
