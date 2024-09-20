package com.lrijn.day4;

import com.lrijn.FileReading;

import java.util.ArrayList;

public class Day4Part1 {
    public static void main(String[] args) {
        String input = FileReading.readFile("com/lrijn/day4/input.txt");
//          String input = """
//                  2-4,6-8
//                  2-3,4-5
//                  5-7,7-9
//                  2-8,3-7
//                  6-6,4-6
//                  2-6,4-8
//                  """;
        int overlappingPairs = 0;
        for(String s : input.split("\n")){

            ArrayList<Integer> range1 = new ArrayList<>();
            ArrayList<Integer> range2 = new ArrayList<>();
            ArrayList<Integer> completeRange1 = new ArrayList<>();
            ArrayList<Integer> completeRange2 = new ArrayList<>();
            int counter = 1;
            for (String str : s.split(",")){

                if(counter ==1){
                    for (String x : str.split("-")){
                        range1.add(Integer.parseInt(x));
                    }

                    for (int i = range1.get(0); i <= range1.get(1); i++){
                        completeRange1.add(i);
                    }
                }else{
                    for (String x : str.split("-")){
                        range2.add(Integer.parseInt(x));
                    }

                    for (int i = range2.get(0); i <= range2.get(1); i++){
                        completeRange2.add(i);
                    }
                }
                counter++;
            }

            int shortListSize = 0;

            if (completeRange1.size() >= completeRange2.size()){
                shortListSize = completeRange2.size();
            }else{
                shortListSize = completeRange1.size();
            }

            ArrayList<Integer> overlap = new ArrayList<>(completeRange1);
            overlap.retainAll(completeRange2);

            if (overlap.size() == shortListSize){
                overlappingPairs++;
            }

        }
        System.out.println("pairs that overlap: " + overlappingPairs);
    }
}
