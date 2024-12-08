package com.sooin.miniproject.controllers;

import com.sooin.miniproject.models.User;
import com.sooin.miniproject.services.UserService;
import com.sooin.miniproject.provider.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String userPassword) {
        User user = userService.findByUserName(userName);
        if (user != null && user.getUserPassword().equals(userPassword)) {
            return jwtProvider.generateToken(userName);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/validate")
    public String validate(@RequestParam String token) {
        String userName = jwtProvider.validate(token);
        if (userName != null) {
            return "Token is valid for user: " + userName;
        }
        throw new RuntimeException("Invalid or expired token");
    }
}
