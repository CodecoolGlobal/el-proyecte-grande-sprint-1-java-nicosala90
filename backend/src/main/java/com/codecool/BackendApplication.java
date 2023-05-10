package com.codecool;

import com.codecool.model.Client;
import com.codecool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    private ClientService clientService;

    @Autowired
    public BackendApplication(ClientService clientService) {
        this.clientService = clientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clientService.addClient(new Client("Arnold Swarczenegger", "valai@gmail.com", "password", LocalDate.now()));
        clientService.
    }
}
