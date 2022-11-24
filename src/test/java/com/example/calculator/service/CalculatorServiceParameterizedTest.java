package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(CalculatorService.class)
class CalculatorServiceParameterizedTest {
    @Autowired
private CalculatorService calculatorService;
    @ParameterizedTest
    @MethodSource("prepareDataForPlus")

    void plus(Integer num1,Integer num2,Integer expected) {
        assertEquals(expected,calculatorService.plus(num1,num2));
    }

    @ParameterizedTest
    void minus() {
    }

    @ParameterizedTest
    void multiply() {
    }

    @ParameterizedTest
    void divide() {
    }
    private static Stream<Arguments> prepareDataForPlus(){
        return Stream.of(
                Arguments.of(5,3,8),
                Arguments.of(7,10,17)
        );
    }
}