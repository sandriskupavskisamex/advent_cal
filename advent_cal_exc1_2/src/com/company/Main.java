package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int totalFuelNeeded = 0;
        int thisFuelNeeded = 0;

        try( Scanner sc = new Scanner(new File("test.txt"))) {
            while(sc.hasNextInt()){

                int number = sc.nextInt();

                int divided_by_three = number/3;

                int rounded_down = (int) Math.floor(divided_by_three);

                int minused_by_two = rounded_down - 2;

                thisFuelNeeded = minused_by_two;

                totalFuelNeeded = totalFuelNeeded + thisFuelNeeded;

                int lessAndLessFuel = thisFuelNeeded;

                while(lessAndLessFuel >= 0) {
                    lessAndLessFuel = (int) Math.floor(lessAndLessFuel/3) - 2;
                    if(lessAndLessFuel > 0) {
                        totalFuelNeeded = totalFuelNeeded + lessAndLessFuel;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println(totalFuelNeeded);

    }
}