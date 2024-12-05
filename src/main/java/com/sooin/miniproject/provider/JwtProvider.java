package com.sooin.miniproject.provider;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME = 1000 * 60 * 60;
    
    public String generateToken(String userName) {
         
        String jwt = Jwts.builder()
            .signWith(SECRET_KEY)
            .setSubject(userName)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .compact();

        return jwt;
    }

    public String validate(String jwt) {

        Claims claims = null;

        try {
            claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();

    }
}
