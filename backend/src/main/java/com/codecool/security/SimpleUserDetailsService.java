package com.codecool.security;

import com.codecool.model.Client;
import com.codecool.repository_DAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SimpleUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Autowired
    public SimpleUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     /*   String[] usernameAndDomain = StringUtils.split(
                username, String.valueOf(Character.LINE_SEPARATOR));
        if (usernameAndDomain == null || usernameAndDomain.length != 2) {
            throw new UsernameNotFoundException("Username and domain must be provided");
        }*/
        Client client = clientRepository.findClientByClientName(username);
        if (client == null) {
            throw new UsernameNotFoundException(String.format("Username not found for domain, username=%s, domain=%s"));
        }
        return client;
    }
}

