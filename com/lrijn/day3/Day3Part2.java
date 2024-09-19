package com.lrijn.day3;

import com.lrijn.FileReading;

import java.util.ArrayList;

import static java.lang.Character.isLowerCase;

public class Day3Part2 {
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


        int counter = 0;
        int finalScore = 0;
        String[] in = input.split("\n");
        ArrayList<String> groups = new ArrayList<>();

        for(int i = 0 ; i < in.length; i+=3){
            ArrayList<String> group = new ArrayList<>();
            group.add(in[0+i]);
            group.add(in[1+i]);
            group.add(in[2+i]);

            int length = 100;
            int index = 1;
            int shortestGroup =0;
            for(String gr : group){
                int len = gr.length();
                if(len < length){
                    length = len;
                    shortestGroup = index;
                }
                index++;
            }

            ArrayList<Character> rucksack1 = new ArrayList<>();
            for (int count = 0; count < group.get(0).length() ; count++ ){
                rucksack1.add(group.get(0).charAt(count));
            }
            ArrayList<Character> rucksack2 = new ArrayList<>();
            for (int count = 0; count < group.get(1).length() ; count++ ){
                rucksack2.add(group.get(1).charAt(count));
            }
            ArrayList<Character> rucksack3 = new ArrayList<>();
            for (int count = 0; count < group.get(2).length() ; count++ ){
                rucksack3.add(group.get(2).charAt(count));
            }

            char character = 'a';
            if (shortestGroup == 1){
                for (char ch: rucksack1){
                    if(rucksack2.contains(ch)){
                        if(rucksack3.contains(ch)){
                            character = ch;
                        }
                    }
                }
            }
            if (shortestGroup == 2){
                for (char ch: rucksack2){
                    if(rucksack1.contains(ch)){
                        if(rucksack3.contains(ch)){
                            character = ch;
                        }
                    }
                }
            }
            if (shortestGroup == 3){
                for (char ch: rucksack3){
                    if(rucksack1.contains(ch)){
                        if(rucksack2.contains(ch)){
                            character = ch;
                        }
                    }
                }
            }
            int score = 0;

            String alphabetLow = "abcdefghijklmnopqrstuvwxyz";
            String alphabetHigh = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            if(isLowerCase(character)){
                score += alphabetLow.indexOf(character) + 1;
            }else{
                score += alphabetHigh.indexOf(character) + 27;
            }
            
            finalScore += score;

        }
        System.out.println("final score: " + finalScore);
    }
}
