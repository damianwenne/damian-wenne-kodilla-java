package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testAddCalculations(){
        //When
        double result = calculator.add(5,10);

        //Then
        Assert.assertEquals(15,result, 0);
    }
}
