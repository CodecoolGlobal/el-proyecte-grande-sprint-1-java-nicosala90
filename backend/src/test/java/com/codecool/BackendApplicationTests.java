package com.codecool;

import com.codecool.logic.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Test
    public void argumentsCannotBeZero() {
        var calculator = new Calculator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.BMICalculator(0, 0));
    }

}
