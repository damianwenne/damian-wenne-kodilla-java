package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite implements ArrayOperations {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {12, 13, 54, 84};

        //When
        ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(40.75, ArrayOperations.getAverage(numbers));

    }
}
