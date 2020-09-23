package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        double addResult = a + b;
        display.displayValue(addResult);
        return addResult;
    }

    public double sub(double a, double b) {
        double subResult = a - b;
        display.displayValue(subResult);
        return subResult;
    }

    public double mul(double a, double b) {
        return 0;
    }

    public double div(double a, double b) {
        return a / b;
    }
}
