package src.Day_3;

import src.Day_2.Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    public void part1() throws Exception {
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_3/day3input.txt"));
        int prioritySum = 0;
        while (reader.hasNext()) {
            String str = reader.next();
            String part1 = str.substring(0, str.length() / 2);
            String part2 = str.substring(str.length() / 2);
            int adding = 0;
            for (int i = 0; i < part1.length(); i++) {
                char charC = part1.charAt(i);
                for (int j = 0; j < part2.length(); j++) {
                    if (charC == part2.charAt(j) && adding == 0) {
                        if (charC >= 97) {
                            adding = charC - 96;
                            prioritySum += adding;
                        } else {
                            adding = charC - 38;
                            prioritySum += adding;
                        }
                    }
                }
            }
        }
        System.out.println(prioritySum);
    }

    public void part2() throws Exception {
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_3/day3input.txt"));
        int sum = 0;
        while (reader.hasNext()){
            ArrayList<String> part1 = new ArrayList<>(Arrays.asList(reader.next().split("")));
            ArrayList<String> part2 = new ArrayList<>(Arrays.asList(reader.next().split("")));
            ArrayList<String> part3 = new ArrayList<>(Arrays.asList(reader.next().split("")));
            for(int i = 0; i<part1.size(); i++){
                if(part2.contains(part1.get(i)) && part3.contains(part1.get(i))){
                    char charC = part1.get(i).charAt(0);
                    if (charC >= 97) {
                        sum += charC - 96;
                    } else {
                        sum += charC - 38;
                    }
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        Day3 day3 = new Day3();
        day3.part1();
        day3.part2();
    }
}
