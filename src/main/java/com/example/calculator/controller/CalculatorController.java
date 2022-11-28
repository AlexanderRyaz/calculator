package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public ResponseEntity<Object> welcome() {
        return new ResponseEntity<>("Добро пожаловать в калькулятор", HttpStatus.OK);
    }

    @GetMapping("/plus")
    public ResponseEntity<Object> plus(@RequestParam(value = "num1", required = false) Integer num1,
                                       @RequestParam(value = "num2", required = false) Integer num2) {
        return new ResponseEntity<>(calculatorService.plus(num1, num2), HttpStatus.OK);
    }

    @GetMapping("/minus")
    public ResponseEntity<Object> minus(@RequestParam(value = "num1", required = false) Integer num1,
                                        @RequestParam(value = "num2", required = false) Integer num2) {
        return new ResponseEntity<>(calculatorService.minus(num1, num2), HttpStatus.OK);
    }

    @GetMapping("/multiply")
    public ResponseEntity<Object> multiply(@RequestParam(value = "num1", required = false) Integer num1,
                                           @RequestParam(value = "num2", required = false) Integer num2) {
        return new ResponseEntity<>(calculatorService.multiply(num1, num2), HttpStatus.OK);
    }

    @GetMapping("/divide")
    public ResponseEntity<Object> divide(@RequestParam(value = "num1", required = false) Integer num1,
                                         @RequestParam(value = "num2", required = false) Integer num2) {
        return new ResponseEntity<>(calculatorService.divide(num1, num2), HttpStatus.OK);
    }
}
