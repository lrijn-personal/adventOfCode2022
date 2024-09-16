package com.lrijn.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
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
            int highestCal = 0;

            for (String s : calories.split("\n")) {
                String cal = s.trim();
                if(!cal.isBlank()){
                    sumOfCal += Integer.parseInt(s);
                }else{
                    if (sumOfCal > highestCal){
                        highestCal = sumOfCal;
                    }
                    sumOfCal = 0;
                }
            }
            System.out.println("Highest number of calories: " + highestCal);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
