package com.company;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayOfValues = new ArrayList<>();
        ArrayList<Integer> originalArray = arrayOfValues;

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
        int result = 0;


        int j = 0;
        int k = 0;

        int myNoun = 0;
        int myVerb = 0;

        while(result == 0) {

            for(j = 1; j <= 99; j++) {
                myNoun = j;
                for(k = 1; k <= 99; k++) {
                    myVerb = k;

                    arrayOfValues = new ArrayList<>(originalArray);

                    arrayOfValues.set(1, myNoun);
                    arrayOfValues.set(2, myVerb);

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
                        if (arrayOfValues.get(0) == 19690720) {
                            result = 100 * myNoun + myVerb;
                            System.out.println("The pair of inputs that produced the output as 19690720 were " + myNoun + " and " + myVerb + ".");
                            break;
                        }

                    }

                }

            }

            break;

        }

        System.out.println("The result of (100 * 'noun' + 'verb') is: " + result);

    }
}