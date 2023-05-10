package com.codecool;

import com.codecool.model.BMI;
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
        clientService.saveBMI(new BMI(25.1,LocalDate.of(2021,1,1), new Client(1L)));
        clientService.saveBMI(new BMI(24.9,LocalDate.of(2021,2,1), new Client(1L)));
        clientService.saveBMI(new BMI(23.6,LocalDate.of(2021,3,1), new Client(1L)));
        clientService.saveBMI(new BMI(22.9,LocalDate.of(2021,4,1), new Client(1L)));
        clientService.saveBMI(new BMI(22.6,LocalDate.of(2021,5,1), new Client(1L)));
        clientService.saveBMI(new BMI(21.8,LocalDate.of(2021,6,1), new Client(1L)));
        clientService.saveBMI(new BMI(21.9,LocalDate.of(2021,7,1), new Client(1L)));
        clientService.saveBMI(new BMI(22.1,LocalDate.of(2021,8,1), new Client(1L)));
        clientService.saveBMI(new BMI(21.1,LocalDate.of(2021,9,1), new Client(1L)));
        clientService.saveBMI(new BMI(20.1,LocalDate.of(2021,10,1), new Client(1L)));
    }
}
