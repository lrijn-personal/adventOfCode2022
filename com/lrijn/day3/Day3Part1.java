package com.lrijn.day3;

import com.lrijn.FileReading;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Day3Part1 {
    public static void main(String[] args) {
        String input = FileReading.readFile("com/lrijn/day3/input.txt");

//        String input = """
//                vJrwpWtwJgWrhcsFMMfFFhFp
//                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
//                PmmdzqPrVvPwwTWBwg
//                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
//                ttgJtRGJQctTZtZT
//                CrZsJsPPZsGzwwsLwLmpwMDw
//                """;

        char ch = 'a';
        int lowscore = 0;
        int highscore = 0;

        for (String s : input.split("\n")){
            int mid = s.length()/2;
            String[] compartments = {s.substring(0, mid), s.substring(mid, s.length())};

            ArrayList<Character> comp1 = new ArrayList<>();
            for (int i = 0; i<mid ; i++){
                comp1.add(compartments[0].charAt(i));
            }

            ArrayList<Character> comp2 = new ArrayList<>();
            for (int i = 0; i< mid ; i++){
                comp2.add(compartments[1].charAt(i));
            }

            for (int i = 0; i < mid ; i++){
                if(comp1.contains(comp2.get(i))){
                    ch = comp2.get(i);
                }
            }

            String alphabetLow = "abcdefghijklmnopqrstuvwxyz";
            String alphabetHigh = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            if(isLowerCase(ch)){
                lowscore += alphabetLow.indexOf(ch) + 1;
            }else{
                highscore += alphabetHigh.indexOf(ch) + 27;
            }
        }
        System.out.println(lowscore + highscore);
    }


}
