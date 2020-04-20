package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        // Test SimpleUser
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        //Test Calculator Add
        Integer result2 = calculator.add(10, 15);

        if (result2.equals(25)) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Test Calculator Subtract
        Integer result3 = calculator.subtract(10, 15);

        if (result3.equals(-5)) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}
