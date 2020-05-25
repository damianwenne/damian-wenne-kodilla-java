package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0,1);
        numbers.add(1,2);
        numbers.add(2,3);
        numbers.add(3,4);
        numbers.add(4,5);


        ArrayList<Integer> value = OddNumbersExterminator.exterminate(numbers);
        System.out.println(value);


    }


}
