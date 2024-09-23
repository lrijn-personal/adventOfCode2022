package com.lrijn.day5;

import com.lrijn.FileReading;

import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day5Part1 {
    public static void main(String[] args) {
        String input = FileReading.readFile("com/lrijn/day5/input.txt");
       /*  String input = """
                      [D]
                  [N] [C]
                  [Z] [M] [P]
                   1   2   3

                  move 1 from 2 to 1
                  move 3 from 1 to 3
                  move 2 from 2 to 1
                  move 1 from 1 to 2
                  """;*/
//        ArrayList<String> crate1 = new ArrayList<>(Arrays.asList("Z","N"));
//        ArrayList<String> crate2 = new ArrayList<>(Arrays.asList("M","C","D"));
//        ArrayList<String> crate3 = new ArrayList<>(Arrays.asList("P"));

        ArrayList<String> crate1 = new ArrayList<>(Arrays.asList("B","Q","C"));
        ArrayList<String> crate2 = new ArrayList<>(Arrays.asList("R","Q", "W","Z"));
        ArrayList<String> crate3 = new ArrayList<>(Arrays.asList("B","M","R","L","V"));
        ArrayList<String> crate4 = new ArrayList<>(Arrays.asList("C","Z","H","V","T","W"));
        ArrayList<String> crate5 = new ArrayList<>(Arrays.asList("D","Z","H","B","N","V","G"));
        ArrayList<String> crate6 = new ArrayList<>(Arrays.asList("H","N","P","C","J","F","V","Q"));
        ArrayList<String> crate7 = new ArrayList<>(Arrays.asList("D","G","T","R","W","Z","S"));
        ArrayList<String> crate8 = new ArrayList<>(Arrays.asList("C","G","M","N","B","W","Z","P"));
        ArrayList<String> crate9 = new ArrayList<>(Arrays.asList("N","J","B","M","W","Q","F","P"));

        for (String s : input.split("\n")){
              if (s.startsWith("move")){
                  String str = s.replaceAll("(\\d+).+", "$1");
                  int numberOfCrates = Integer.parseInt(str.replace("move ",""));
                  int fromCrate = Integer.parseInt(s.replaceAll(".*?(\\d+).*?(\\d+).*", "$2"));
                  int toCrate = Integer.parseInt(s.replaceAll(".*?(\\d+).*?(\\d+).*?(\\d+).*", "$3"));


                  HashMap<Integer, ArrayList<String>> crateNamesMap = new HashMap<> ();
                  crateNamesMap.put(1, crate1);
                  crateNamesMap.put(2, crate2);
                  crateNamesMap.put(3, crate3);
                  crateNamesMap.put(4, crate4);
                  crateNamesMap.put(5, crate5);
                  crateNamesMap.put(6, crate6);
                  crateNamesMap.put(7, crate7);
                  crateNamesMap.put(8, crate8);
                  crateNamesMap.put(9, crate9);

                  for (int i = 0; i<numberOfCrates; i++){
                      if (!crateNamesMap.get(fromCrate).isEmpty()){
                          String item = crateNamesMap.get(fromCrate).getLast();
                          crateNamesMap.get(toCrate).add(item);
                          crateNamesMap.get(fromCrate).remove(item);
                      }
                  }
                 // System.out.println("---------");
                  System.out.println(crateNamesMap);

              }

              }

        }
    }


