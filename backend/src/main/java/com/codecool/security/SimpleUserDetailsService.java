package com.codecool.security;

import com.codecool.model.Client;
import com.codecool.repository_DAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;


@EnableWebSecurity
@Configuration
public class SimpleUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] usernameAndDomain = StringUtils.split(
                username, String.valueOf(Character.LINE_SEPARATOR));
        if (usernameAndDomain == null || usernameAndDomain.length != 2) {
            throw new UsernameNotFoundException("Username and domain must be provided");
        }
        Client client = clientRepository.find (usernameAndDomain[0], usernameAndDomain[1]);
        if (client == null) {
            throw new UsernameNotFoundException(
                    String.format("Username not found for domain, username=%s, domain=%s",
                            usernameAndDomain[0], usernameAndDomain[1]));
        }
        return client;
    }
}
