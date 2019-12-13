package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayOfPossiblePasswords = new ArrayList<>();

        for(int i = 147981; i <= 691423; i++) {

            if(hasDouble(i) && digitsNeverDecrease(i)) {
                arrayOfPossiblePasswords.add(i);
            }

        }

        System.out.println("Total possible passwords are: " + arrayOfPossiblePasswords.size());
    }

    public static boolean hasDouble(int number) {
        boolean state = false;

        List<Integer> digits = new ArrayList<>();
        while(number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }

        HashMap<Integer, Integer> occurrencesOfNumbers = new HashMap<>();

        for(int x = 0; x < digits.size(); x++) {
            if(!occurrencesOfNumbers.containsKey(digits.get(x))) {
                occurrencesOfNumbers.put(digits.get(x), 1);
            } else {
                occurrencesOfNumbers.replace(digits.get(x), occurrencesOfNumbers.get(digits.get(x))+1);
            }
        }

        if(occurrencesOfNumbers.containsValue(2)) {
            state = true;
        }

        return state;
    }

    public static boolean digitsNeverDecrease(int number) {
        boolean state = true;

        List<Integer> digits = new ArrayList<>();
        while(number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }

        for(int i = 0; i < digits.size()-1; i++) {
            if(digits.get(i) > digits.get(i+1)) {
                state = false;
            }
        }

        return state;
    }
}