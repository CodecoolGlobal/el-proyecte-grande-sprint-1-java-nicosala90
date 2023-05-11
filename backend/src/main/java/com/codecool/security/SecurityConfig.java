package com.codecool.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {

    private AuthenticationManagerDatabase authenticationManager;
    private AuthenticationSuccessHandlerJwt authenticationSuccessHandlerJwt;

    @Autowired
    public SecurityConfig(AuthenticationManagerDatabase authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .addFilter(new PasswordAuthenticationFilter(authenticationManager))
                .build();

    }
}
