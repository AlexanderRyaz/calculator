package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(CalculatorService.class)
class CalculatorServiceTest {
    @Autowired
    private CalculatorService calculatorService;

    @Test
    void plus() {
        assertEquals(7,calculatorService.plus(5, 2));
        assertEquals(10,calculatorService.plus(4, 6));
    }

    @Test
    void minus() {
        assertEquals(7,calculatorService.minus(9, 2));
        assertEquals(10,calculatorService.minus(16, 6));
    }

    @Test
    void multiply() {
        assertEquals(8,calculatorService.multiply(4, 2));
        assertEquals(10,calculatorService.multiply(5, 2));
    }

    @Test
    void divide() {
        assertEquals(8,calculatorService.divide(16, 2));
        assertEquals(10,calculatorService.divide(20, 2));
    }
    @Test
    void divideByZero(){
        assertThrows(IllegalArgumentException.
                class,()->calculatorService.divide(10,0),"деление на ноль запрещено");
    }
}