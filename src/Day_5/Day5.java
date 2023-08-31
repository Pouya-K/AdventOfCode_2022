package src.Day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    private final File file = new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_5/day5input.txt");
    private Scanner reader;
    private ArrayList<String>[] group;

    public void part1(){
        try {
            reader = new Scanner(file);
            group = new ArrayList[findNumberOfCargoBoxes()];
            reader = new Scanner(file);
            while (reader.hasNext()){
                String line = reader.nextLine();
            }
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    private int findNumberOfCargoBoxes() {
        while (reader.hasNext()){
            String line = reader.nextLine();
            for(int i = line.length()-1; i>=0; i--){
                if(Character.isDigit(line.charAt(i))){
                    return Integer.parseInt(line.substring(i,i+1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.part1();
    }
}
