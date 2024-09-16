package com.lrijn.day2;

/*

oponent
A: Rock
B: paper
c: scissor

You:
X: rock - 1 point
Y: paper - 2 points
Z: scissor - 3 points

winning: A-Y, B-Z, C-X - 6 points
equal: A-X, B-Y, C-Z - 3 points
lose: A-Z, B-X, C-Y - 0 points
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) {
        try{
            File myFile = new File("com/lrijn/day2/input.txt");
            Scanner scanner = new Scanner(myFile);
            StringBuilder fileContent = new StringBuilder();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                fileContent.append(data).append("\n");
            }
            scanner.close();
            String input = fileContent.toString();

            int score = 0;
            for (String line : input.split("\n")){
                if (line.equals("A Y") || line.equals("B Z") || line.equals("C X")){
                    score += 6;
                }
                else if (line.equals("A X") || line.equals("B Y") || line.equals("C Z")){
                    score += 3;
                }
                else if (line.equals("A Z") || line.equals("B X") || line.equals("C Y")) {
                    score += 0;
                }
                for(String you : line.split("\s")){
                    switch(you){
                        case "X":
                            score += 1;
                            break;
                        case "Y":
                            score += 2;
                            break;
                        case "Z":
                            score += 3;
                            break;
                    }
                }
            }
            System.out.println(score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
