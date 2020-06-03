package com.kodilla.testing.shape;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {
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
    public void testAddFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square("Square", 10.0);
        Circle circle = new Circle("Circle", 2.5);
        Triangle triangle = new Triangle("Triangle", 1.8, 2.6);
        shapeCollector.addFigure(square);


        // When


    }

}
