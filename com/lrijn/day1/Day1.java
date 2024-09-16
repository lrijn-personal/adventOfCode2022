package com.lrijn.day1;

public class Day1 {
    public static void main (String[] args){
        String calories  = """
                1000
                2000
                3000
                
                4000
                
                5000
                6000
                
                7000
                8000
                9000
                
                10000
                """;

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
    }
}
