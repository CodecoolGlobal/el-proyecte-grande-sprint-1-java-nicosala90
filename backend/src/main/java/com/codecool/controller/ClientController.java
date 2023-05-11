package com.codecool.controller;

import com.codecool.model.BMI;
import com.codecool.model.Client;
import com.codecool.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(id>0 ? "BMI saved" : "BMI calculated");
        return clientService.calculateBMI(clientData, id);
    }

   /* @GetMapping("/bmi-list/{id}")
    public List<BMI> getBMIValuesByClient(@PathVariable Long id) {
        return clientService.getBMIValuesSortByDate(id);
    }
*/
   @GetMapping("/bmi-list")
   public List<BMI> getBmiList(@RequestHeader("Authorization") String authHeader) {
       System.out.println(authHeader);
       String[] tokenElement = authHeader.split(" ");
       String clientName = tokenElement[0];
       System.out.println(clientName);
       return clientService.getBMIValuesSortByDate(clientName);
   }
    //create
    @PostMapping("/add-client")
    public int addClient(@RequestBody Client newClient) {
        System.out.println("Client saved");
        clientService.addClient(newClient);
        return 1;
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
