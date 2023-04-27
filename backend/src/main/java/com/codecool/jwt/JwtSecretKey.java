package com.codecool.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

import static com.codecool.jwt.JwtUsernameAndPasswordAuthenticationFilter.KEY;

@Configuration
public class JwtSecretKey {
private final JwtConfig jwtConfig;
@Autowired
    public JwtSecretKey(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public SecretKey getSecretKeyForSignIn(){
        return Keys.hmacShaKeyFor(KEY.getBytes());
    }
}
