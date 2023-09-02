package src.Day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day7 {
    private File file = new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_7/day7input.txt");
    private Scanner reader;
    private int sumPart1 = 0;
    private int minimumDelete = 70000000;
    private int spaceNeeded = 0;

    public void getAnswer() {
        try {
            reader = new Scanner(file);
            reader.nextLine();
            Directory mainDirectory = new Directory("/", null);
            runLine(mainDirectory);
            findSumPart1(mainDirectory);
            spaceNeeded = 30000000 - (70000000 - mainDirectory.getSize());
            findSumPart2(mainDirectory);
            System.out.println("Part 1 Answer: " + sumPart1);
            System.out.println("Part 2 Answer: " + minimumDelete);
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }
    public void runLine(Directory directory){
        if(reader.hasNext()){
            String line = reader.nextLine();
            if(line.charAt(0) == '$'){
                if(line.substring(2, 4).equals("cd")){
                    if(line.substring(5).equals("..")){
                        runLine(directory.getParentDirectory());
                    }
                    runLine(directory.findFile(line.substring(5)));
                }
                else{
                    runLine(directory);
                }
            }
            else{
                if(line.charAt(0) == 'd'){
                    directory.addFile(new Directory(line.substring(4), directory));
                }
                else{
                    directory.addFile(new RandomFile(line.substring(line.indexOf(' ') + 1), Integer.parseInt(line.substring(0, line.indexOf(' ')))));
                }
                runLine(directory);
            }
        }
    }

    public void findSumPart1(Directory directory){
        if(directory.getSize() <= 100000){
            sumPart1 += directory.getSize();
        }
        for(int i = 0; i<directory.getFiles().size(); i++){
            if(directory.getFiles().get(i) instanceof Directory){
                findSumPart1((Directory) directory.getFiles().get(i));
            }
        }
    }

    public void findSumPart2(Directory directory){
        if(directory.getSize() < minimumDelete && directory.getSize() >= spaceNeeded){
            minimumDelete = directory.getSize();
        }
        for(int i = 0; i<directory.getFiles().size(); i++){
            if(directory.getFiles().get(i) instanceof Directory){
                findSumPart2((Directory) directory.getFiles().get(i));
            }
        }
    }

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        day7.getAnswer();
    }
}
