package com.kodilla.testing.collection;

import java.util.ArrayList;

class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        for (int i=0; i<numbers.size(); i++) {
            while (numbers.get(i) % 2 == 0) {
                evenNumbers.add(numbers.get(i));
            }
        }
        return evenNumbers;
    }
}



