package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite implements ArrayOperations {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {12, 13, 54, 84, 74, 25, 95, 2, 41, 36, 15, 91, 25, 14, 56, 69, 98, 87, 74, 41};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(50.30, result, 0.001);

    }
}
