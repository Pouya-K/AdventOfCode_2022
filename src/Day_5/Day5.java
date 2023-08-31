package src.Day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    private final File file = new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_5/day5input.txt");
    private Scanner reader;
    private ArrayList<String>[] group;
    private int numberOfCargos = 0;

    public void part2(){
        try {
            reader = new Scanner(file);
            findNumberOfCargoBoxes();
            group = new ArrayList[numberOfCargos];
            for (int i = 0; i < group.length; i++) {
                group[i] = new ArrayList<String>();
            }
            reader = new Scanner(file);
            boolean switchToActions = false;

            while (reader.hasNext()) {
                String line = reader.nextLine();
                if (line.charAt(1) == '1') {
                    switchToActions = true;
                    reader.nextLine();
                    continue;
                }
                if (!switchToActions) {
                    createStartingCargo(line);
                }
                else {
                    makeMovementsPart2(line);
                }
            }
            String finalAnswer = "";
            for(ArrayList<String> cargo : group){
                finalAnswer += cargo.get(0);
            }
            System.out.println("Part 2 Answer: " + finalAnswer);

        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private void makeMovementsPart2(String line) {
        int numberOfMoves = Integer.parseInt(line.substring(5, line.indexOf("from")-1));
        int takeFrom = Integer.parseInt(line.substring(line.indexOf("from")+5, line.indexOf("from")+6)) - 1;
        int bringTo = Integer.parseInt(line.substring(line.indexOf("to")+3, line.indexOf("to")+4)) - 1;
        for(int i = 1; i<=numberOfMoves; i++){
            group[bringTo].add(0,group[takeFrom].get(numberOfMoves-i));
            group[takeFrom].remove(numberOfMoves-i);
        }
    }

    public void part1() {
        try {
            reader = new Scanner(file);
            findNumberOfCargoBoxes();
            group = new ArrayList[numberOfCargos];
            for (int i = 0; i < group.length; i++) {
                group[i] = new ArrayList<String>();
            }
            reader = new Scanner(file);
            boolean switchToActions = false;

            while (reader.hasNext()) {
                String line = reader.nextLine();
                if (line.charAt(1) == '1') {
                    switchToActions = true;
                    reader.nextLine();
                    continue;
                }
                if (!switchToActions) {
                    createStartingCargo(line);
                }
                else {
                    makeMovementsPart1(line);
                }
            }
            String finalAnswer = "";
            for(ArrayList<String> cargo : group){
                finalAnswer += cargo.get(0);
            }
            System.out.println("Part 1 Answer: " + finalAnswer);

        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private void makeMovementsPart1(String line) {
        int numberOfMoves = Integer.parseInt(line.substring(5, line.indexOf("from")-1));
        int takeFrom = Integer.parseInt(line.substring(line.indexOf("from")+5, line.indexOf("from")+6)) - 1;
        int bringTo = Integer.parseInt(line.substring(line.indexOf("to")+3, line.indexOf("to")+4)) - 1;
        for(int i = 1; i<=numberOfMoves; i++){
            group[bringTo].add(0,group[takeFrom].get(0));
            group[takeFrom].remove(0);
        }
    }

    private void createStartingCargo(String line) {
        for (int i = 0, n = 1; i < numberOfCargos; i++) {
            String letter = line.substring(n, n + 1);
            if (!letter.equals(" ")) {
                group[i].add(letter);
            }
            if (n + 4 < line.length()) {
                n += 4;
            } else {
                break;
            }
        }
    }

    private void findNumberOfCargoBoxes() {
        boolean checkDone = false;
        while (reader.hasNext() && !checkDone) {
            String line = reader.nextLine();
            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    numberOfCargos = Integer.parseInt(line.substring(i, i + 1));
                    checkDone = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.part1();
        day5.part2();
    }
}
