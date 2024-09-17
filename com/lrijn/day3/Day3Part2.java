package com.lrijn.day3;

import com.lrijn.FileReading;

import java.util.ArrayList;

public class Day3Part2 {
    public static void main(String[] args) {
        //String input = FileReading.readFile("com/lrijn/day3/input.txt");
        String input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                """;


        int counter = 0;
        String[] in = input.split("\n");
        ArrayList<String> groups = new ArrayList<>();

        for(int i = 0 ; i < in.length; i+=3){
            ArrayList<String> group = new ArrayList<>();
            group.add(in[0+i]);
            group.add(in[1+i]);
            group.add(in[2+i]);

            int length = 0;
            for(String gr : group){
                int len = gr.length();
                if(len > length){
                    length = len;
                }
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

//            for(int count = 0; count < group.get(0).length() ; count++){
//                if(rucksack1.contains(rucksack2.get(count))){
//                    System.out.println(rucksack2.get(count));
//                }
//                else if (rucksack1.contains(rucksack3.get(count))){
//                    System.out.println(rucksack3.get(count));
//                }
//            }
            System.out.println(rucksack1);
            System.out.println(rucksack2);
            System.out.println(rucksack3);


        }
    }
}
