package com.lrijn.day2;

/*

X: you need to lose
Y: you need a draw
Z: you need to win

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
import java.util.Arrays;
import java.util.Scanner;

public class Day2Part2 {
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
//            String input = """
//                    A Y
//                    B X
//                    C Z
//                    """;

            int score = 0;
            for (String line : input.split("\n")){
                line = line.replaceAll("\\s","");
                char elf = line.charAt(0);
                char you = line.charAt(1);

                //lose
                if (you == 'X') {
                    score += 0;
                    if (elf == 'A') {
                        you = 'Z';
                        score += 3;
                    } else if (elf == 'B') {
                        you = 'X';
                        score += 1;
                    } else if (elf == 'C') {
                        you = 'Y';
                        score += 2;
                    }
                }

                //draw (Y)
                else if (you == 'Y') {
                            score += 3;
                            if (elf == 'A') {
                                you = 'X';
                                score += 1;
                            } else if (elf == 'B') {
                                you = 'Y';
                                score += 2;
                            } else if (elf == 'C') {
                                you = 'Z';
                                score += 3;
                            }
                        }

                else if (you == 'Z') {
                    score += 6;
                    if (elf == 'A') {
                        you = 'Y';
                        score += 2;
                    } else if (elf == 'B') {
                        you = 'Z';
                        score += 3;
                    } else if (elf == 'C') {
                        you = 'X';
                        score += 1;
                    }
                }

                }

            System.out.println(score);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
