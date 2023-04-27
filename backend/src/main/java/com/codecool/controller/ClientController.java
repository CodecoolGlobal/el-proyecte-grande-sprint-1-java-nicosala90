package com.codecool.controller;

import com.codecool.model.BMI;
import com.codecool.model.Client;
import com.codecool.model.Message;
import com.codecool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/registeredBMI/{id}")
    public double saveBMI(@RequestBody Client clientData, @PathVariable Long id) {
        return clientService.calculateBMI(clientData, id);
    }

    @GetMapping("/bmi-list/{id}")
    public List<BMI> getBMIValuesByClient(@PathVariable Long id) {
        return clientService.getBMIValuesSortByDate(id);
    }

    //create
    @PostMapping("/sign-in")
    public int addClient(@RequestBody Client newClient) {
        System.out.println(newClient);
        clientService.addClient(newClient);
        return 1;
    }

    @PostMapping("/log-in")
    public Client checkClient(@RequestBody Client clientNameAndPassword) {
        return clientService.clientChecker(clientNameAndPassword);
    }

    @PostMapping("/message")
    public Message checkClient(@RequestBody Message message) {
        return clientService.saveMessage(message);
    }

    @GetMapping("/message-all")
    public List<Message> getAllMessage() {
        return clientService.findAllMessage();
    }

    //get all clients
    @GetMapping("/all-clients")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
