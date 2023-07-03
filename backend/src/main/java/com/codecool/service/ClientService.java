package com.codecool.service;

import com.codecool.model.BMI;
import com.codecool.model.Client;
import com.codecool.logic.Calculator;
import com.codecool.repository_DAO.BMIRepository;
import com.codecool.repository_DAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private BMIRepository bmiRepository;

    private Calculator calculator;

    @Autowired
    public ClientService(ClientRepository clientRepository, BMIRepository bmiRepository, Calculator calculator) {
        this.clientRepository = clientRepository;
        this.bmiRepository = bmiRepository;
        this.calculator = calculator;
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public double calculateBMI(Client client, Long id) {
        client.setId(id);
        double BMIResult = calculator.calculator(client.getWeight(), client.getHeight());
        if (id > 0) {
            BMI bmi = BMI.builder()
                    .bmiValues(BMIResult)
                    .localDate(LocalDate.now())
                    .client(client)
                    .build();
            client.addCalculatedBMI(bmi);
            bmiRepository.save(bmi);
            return BMIResult;
        }
        return BMIResult;
    }

    public List<BMI> getBMIValuesSortByDate(Long id) {
        Client user = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        return user.getBmiValues()
                .stream()
                .sorted(Comparator.comparing(BMI::getLocalDate))
                .collect(Collectors.toList());
    }

    public int getClientAge(Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new)
                .calculateClientAge();
    }

}
