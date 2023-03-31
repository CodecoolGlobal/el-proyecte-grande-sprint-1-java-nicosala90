package com.codecool.logic;

import com.codecool.data.user.User;

public class Calculator {

    public double BMICalculator(double weight, double height){
        if (weight <= 0 || height <= 0)
            throw new IllegalArgumentException("Height and weight must be positive");
        return weight / Math.pow(height,2);
    }
}
