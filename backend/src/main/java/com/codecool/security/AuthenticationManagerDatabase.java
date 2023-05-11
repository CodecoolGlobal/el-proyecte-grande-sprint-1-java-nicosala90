package com.codecool.security;

import com.codecool.model.Client;
import com.codecool.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthenticationManagerDatabase implements AuthenticationManager {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ClientService clientService;

    @Autowired
    public AuthenticationManagerDatabase(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        logger.info("Authentication Object: {}", authentication);
//        logger.info("Type of principal : {}", authentication.getPrincipal().getClass());
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        Client client = clientService.getClientByClientName(username);
        logger.info("client is: {}", client);

        //TODO hash + salt password
        if (client != null && password.equals(client.getPassword())) {
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
        }
        throw new BadCredentialsException("Bad credentials");
    }
}
