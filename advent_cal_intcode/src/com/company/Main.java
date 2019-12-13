package com.company;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayOfValues = new ArrayList<>();

        try {

            Scanner sc = new Scanner(new File("test.txt"));
            sc.useDelimiter(",");

            while (sc.hasNextInt()) {
                int current_value = sc.nextInt();
                arrayOfValues.add(current_value);
            }

            sc.close();

        } catch (Exception ignored) {
            System.out.println(ignored);
        }

        int position_one = 0;
        int position_two = 0;
        int position_three = 0;

        arrayOfValues.set(1, 12);
        arrayOfValues.set(2, 2);

        for (int i = 0; i < arrayOfValues.size() - 4; i = i + 4) {

            position_one = arrayOfValues.get(i + 1);
            position_two = arrayOfValues.get(i + 2);
            position_three = arrayOfValues.get(i + 3);

            if(position_three > 145) {
                continue;
            }

            if (arrayOfValues.get(i) == 1 && position_three < 145) {
                arrayOfValues.set(position_three, arrayOfValues.get(position_one) + arrayOfValues.get(position_two));
            }

            if (arrayOfValues.get(i) == 2 && position_three < 145) {
                arrayOfValues.set(position_three, arrayOfValues.get(position_one) * arrayOfValues.get(position_two));
            }

            if (arrayOfValues.get(i) == 99) {
                break;
            }

        }

        System.out.println("Value left at position zero is: " + arrayOfValues.get(0));

    }
}