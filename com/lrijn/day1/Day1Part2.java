package com.lrijn.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part2 {
    public static void main (String[] args){

        try{
            File myObj = new File("com/lrijn/day1/input.txt");
            Scanner scanner = new Scanner(myObj);
            StringBuilder fileContent = new StringBuilder();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                fileContent.append(data).append("\n");
            }
            scanner.close();

            String calories  = fileContent.toString();

            int sumOfCal = 0;
            int highestCal1 = 0;
            int highestCal2 = 0;
            int highestCal3 = 0;

            for (String s : calories.split("\n")) {
                String cal = s.trim();
                if(!cal.isBlank()){
                    sumOfCal += Integer.parseInt(s);
                }else{
                    if (sumOfCal > highestCal1){
                        highestCal3 = highestCal2;
                        highestCal2 = highestCal1;
                        highestCal1 = sumOfCal;
                    }
                    else if (sumOfCal > highestCal2){
                        highestCal3 = highestCal2;
                        highestCal2 = sumOfCal;
                    }
                    else if (sumOfCal > highestCal3){
                        highestCal3 = sumOfCal;
                    }
                    sumOfCal = 0;
                }
            }
            System.out.println("Highest 3 numbers of calories: " + highestCal1 + " " + highestCal2 + " " + highestCal3);
            int sumOfHighThree = highestCal1 + highestCal2 + highestCal3;
            System.out.println("Sum of highest 3 calories: " + sumOfHighThree);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
