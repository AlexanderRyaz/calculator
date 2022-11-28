package com.example.calculator.service;

import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class CalculatorService {
    public int plus(Integer num1, Integer num2) {
        check(num1, num2);
        return num1 + num2;
    }

    public int minus(Integer num1, Integer num2) {
        check(num1, num2);
        return num1 - num2;
    }

    public int multiply(Integer num1, Integer num2) {
        check(num1, num2);
        return num1 * num2;
    }

    public double divide(Integer num1, Integer num2) {
        check(num1, num2);
        if (num2 == 0) {
            throw new IllegalArgumentException("деление на ноль запрещено");
        }
        return num1 * 1.0 / num2;
    }

    private void check(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new InvalidParameterException("не заданы параметры");
        }
    }
}
