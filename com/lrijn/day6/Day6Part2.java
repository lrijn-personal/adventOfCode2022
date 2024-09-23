package com.lrijn.day6;

import com.lrijn.FileReading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day6Part2 {
    public static void main(String[] args) {
        String input = FileReading.readFile("com/lrijn/day6/input.txt");
        // String input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"; //answer = 19
        // String input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

        ArrayList<Character> ch = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            ch.add(input.charAt(i));
        }

        HashMap<Integer,ArrayList<Character>> groups = new HashMap<>();
        int group = 1;
        int count = 0;
        for(char x : ch){
            ArrayList<Character> fourChars = new ArrayList<>();
            for (int i=count ; i < count + 14 & i < ch.size() ; i++){
                fourChars.add(ch.get(i));
            }
            count++;
            groups.put(group, fourChars);
            group++;
        }
        for(int i = 1 ; i < groups.size() ; i++){
            Set<Character> uniqueSet = new HashSet<>();
            Set<Character> duplicateSet = new HashSet<>();
            for (int x =0 ; x < groups.get(i).size() ; x++  ){
                char character = groups.get(i).get(x);
                if(!uniqueSet.add(character)){
                    duplicateSet.add(character);
                }

            }

            if (duplicateSet.isEmpty()){
                System.out.println("character: " + (i+13));
                return;
            }
        }

    }
}
