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

    @Test
    public void testSubCalculations(){
        //When
        double result = calculator.sub(5,10);

        //Then
        Assert.assertEquals(-5,result, 0);
    }

    @Test
    public void testMulCalculations(){
        //When
        double result = calculator.mul(5,10);

        //Then
        Assert.assertEquals(50,result, 0);
    }

    @Test
    public void testDivCalculations(){
        //When
        double result = calculator.div(5,10);

        //Then
        Assert.assertEquals(0.5,result, 0);
    }
}
