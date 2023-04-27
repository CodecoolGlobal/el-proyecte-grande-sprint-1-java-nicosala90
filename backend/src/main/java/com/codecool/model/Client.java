package com.codecool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String clientName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private double weight;
    private double height;

    @OneToMany(mappedBy = "client")
    private List<BMI> bmiValues = new ArrayList<>();

    @Autowired
    public Client(String clientName, String email, String password, LocalDate dateOfBirth) {
        this.clientName = clientName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Client(LocalDate dateOfBirth, double weight, double height) {
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public void addCalculatedBMI(BMI bmi) {
        bmiValues.add(bmi);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdayDate=" + dateOfBirth +
                ", height=" + height +
                ", bmiValues=" + bmiValues +
                '}';
    }
}
