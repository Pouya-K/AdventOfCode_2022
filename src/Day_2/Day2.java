package src.Day_2;

import java.io.File;
import java.util.Scanner;

public class Day2 {
    public void part1() throws Exception{
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_2/day2input.txt"));
        int score = 0;
        while(reader.hasNext()){
            char play1 = reader.next().charAt(0);
            char play2 = reader.next().charAt(0);
            /**
             *
             */
            switch (play2){
                case 'X':
                    score++;
                    if(play1 == 'A') score += 3;
                    else if(play1 == 'C') score += 6;
                    break;
                case 'Y':
                    score += 2;
                    if(play1 == 'B') score += 3;
                    else if(play1 == 'A') score += 6;
                    break;
                case 'Z':
                    score += 3;
                    if(play1 == 'C') score += 3;
                    else if(play1 == 'B') score += 6;
                    break;
            }
        }
        System.out.println(score);
    }

    public void part2() throws Exception {
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_2/day2input.txt"));
        int score = 0;
        while(reader.hasNext()){
            char play1 = reader.next().charAt(0);
            char play2 = reader.next().charAt(0);
            /**
             *
             */
            switch (play2){
                case 'X':
                    if(play1 == 'A') score += 3;
                    else if(play1 == 'B') score += 1;
                    else score += 2;
                    break;
                case 'Y':
                    score += 3;
                    if(play1 == 'A') score += 1;
                    else if(play1 == 'B') score += 2;
                    else score += 3;
                    break;
                case 'Z':
                    score += 6;
                    if(play1 == 'A') score += 2;
                    else if(play1 == 'B') score += 3;
                    else score += 1;
                    break;
            }
        }
        System.out.println(score);
    }

    public static void main(String[] args) throws Exception {
        Day2 day2 = new Day2();
        day2.part1();
        day2.part2();
    }
}
