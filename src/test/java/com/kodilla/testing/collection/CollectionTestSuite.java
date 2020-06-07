package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the begining of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // When
        OddNumbersExterminator.exterminate(numbers);

        //Then
        Assert.assertEquals(numbers, OddNumbersExterminator.exterminate(numbers));

    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0,1);
        numbers.add(1,2);
        numbers.add(2,3);
        numbers.add(3,4);
        numbers.add(4,5);

        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        evenNumbers.add(2);
        evenNumbers.add(4);


        // When
        OddNumbersExterminator.exterminate(numbers);

        // Then
        Assert.assertEquals(evenNumbers, OddNumbersExterminator.exterminate(numbers));
    }


}
