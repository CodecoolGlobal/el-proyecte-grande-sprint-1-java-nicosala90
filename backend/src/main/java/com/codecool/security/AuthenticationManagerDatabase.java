package com.codecool.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationManagerDatabase implements AuthenticationManager {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("Authentication Object: {}", authentication);
        logger.info("Type of principal : {}", authentication.getPrincipal().getClass());
        return null;
    }
}
