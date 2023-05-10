package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BMI {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double bmiValues;
    private LocalDate localDate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    public BMI(double bmiValues, LocalDate localDate, Client client) {
        this.bmiValues = bmiValues;
        this.localDate = localDate;
        this.client = client;
    }
}
