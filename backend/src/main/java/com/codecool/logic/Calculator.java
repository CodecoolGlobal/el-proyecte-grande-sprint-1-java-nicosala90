package com.codecool.logic;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Calculator {

    public double calculator(double weight, double height){
    return weight / Math.pow(height,2);
    }
}
