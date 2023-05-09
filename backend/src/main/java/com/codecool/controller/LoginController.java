package com.codecool.controller;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String loginClient(@CurrentSecurityContext SecurityContext securityContext){
        String user = (String) securityContext.getAuthentication().getPrincipal();
        return "hello  " + user;
    }
}
