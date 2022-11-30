package com.example.bdf.ejemplos;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;
    @Mock
    private DataService dataService;

    @Test
    public void sumaPositivosTest() {
        when(dataService.sumar(2,3)).thenReturn(5);
        assertEquals(5, calculatorService.calculateSum(2,3));
    }

    @Test
    public void sumaNegativosTest() {
        when(dataService.sumar(-2,3)).thenReturn(1);
        assertEquals(1, calculatorService.calculateSum(-2,3));
    }

    @Test
    public void sumaVacioTest() {
        when(dataService.sumar(0,0)).thenReturn(0);
        assertEquals(0, calculatorService.calculateSum(0,0));
    }

}