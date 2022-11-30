package com.example.bdf.ejemplos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    private DataService dataService;

    @Autowired
    public CalculatorService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int a, int b) {
        int number = dataService.sumar(a,b);
        return number;
    }
}
