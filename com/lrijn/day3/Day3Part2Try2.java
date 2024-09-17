package com.lrijn.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day3Part2Try2 {
    public static void main(String[] args) {
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

        for(int i = 0 ; i < in.length; i+=3) {
            ArrayList<String> group = new ArrayList<>();
            group.add(in[0 + i]);
            group.add(in[1 + i]);
            group.add(in[2 + i]);
            System.out.println(group);

            Set<Character> group1 = toCharacterSet(group.get(0));
            Set<Character> group2 = toCharacterSet(group.get(1));
            Set<Character> group3 = toCharacterSet(group.get(2));
            System.out.println(group1);
            System.out.println(group2);
            System.out.println(group3);
        }

    }

    private static Set<Character> toCharacterSet(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            characterSet.add(c);
        }
        return characterSet;
    }
}
