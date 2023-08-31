package src.Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
    Scanner reader;
    File file = new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_6/day6input.txt");
    public void part1And2(){
        try {
            reader = new Scanner(file);
            String line = reader.nextLine();
            System.out.println("Part 1 Answer: " + findFirstSequence(line, 4));
            System.out.println("Part 2 Answer: " + findFirstSequence(line, 14));
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private int findFirstSequence(String line, int num) {
        for(int i = num-1; i< line.length(); i++){
            if(checkForWin(line.substring(i-num+1, i+1))){
                return i + 1;
            }
        }
        return 0;
    }
    public boolean checkForWin(String sequence){
        for(int i = 0; i<sequence.length()-1; i++){
            for(int j = i+1; j<sequence.length(); j++){
                if(sequence.charAt(i) == sequence.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Day6 day6 = new Day6();
        day6.part1And2();
    }
}
