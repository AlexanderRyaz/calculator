package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(CalculatorService.class)
class CalculatorServiceParameterizedTest {
    @Autowired
    private CalculatorService calculatorService;

    @ParameterizedTest
    @MethodSource("prepareDataForPlus")
    void plus(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("prepareDataForMinus")
    void minus(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.minus(num1, num2));
    }


    @ParameterizedTest
    @MethodSource("prepareDataForMultiply")
    void multiply(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("prepareDataForDivide")
    void divide(Integer num1, Integer num2, Double expected) {
        assertEquals(expected, calculatorService.divide(num1, num2));
    }
@ParameterizedTest
@MethodSource("prepareDataForNullCheck")
void nullCheck(Integer num1,Integer num2){
        assertThrows(InvalidParameterException.class,()->calculatorService.
                plus(num1,num2),"не заданы параметры");
}
    private static Stream<Arguments> prepareDataForPlus() {
        return Stream.of(
                Arguments.of(5, 3, 8),
                Arguments.of(7, 10, 17)
        );
    }

    private static Stream<Arguments> prepareDataForMinus() {
        return Stream.of(
                Arguments.of(5, 3, 2),
                Arguments.of(10, 7, 3)
        );
    }
    private static Stream<Arguments> prepareDataForMultiply() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(10, 7, 70)
        );
    }
    private static Stream<Arguments> prepareDataForDivide() {
        return Stream.of(
                Arguments.of(2, 2, 1.0),
                Arguments.of(10, 5, 2.0)
        );
    }
    private static Stream<Arguments> prepareDataForNullCheck() {
        return Stream.of(
                Arguments.of(null, 2),
                Arguments.of(10, null),
                Arguments.of(null, null)
        );
    }
}