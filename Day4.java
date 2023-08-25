import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.part1();
        day4.part2();
    }

    public void part1() {
        try {
            Scanner reader = new Scanner(new File("day4input.txt"));
            int numberOfMishaps = 0;
            while (reader.hasNext()) {
                String line = reader.next();
                String part1 = line.substring(0, line.indexOf(','));
                String part2 = line.substring(line.indexOf(',') + 1);
                if (oneContainsOther(part1, part2)){
                    numberOfMishaps++;
                }
            }
            System.out.println(numberOfMishaps);
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("File reading messed up");
            e.printStackTrace();
        }
    }

    public boolean oneContainsOther(String part1, String part2) {
        int[] numbers = new int[4];
        numbers[0] = Integer.parseInt(part1.substring(0, part1.indexOf('-')));
        numbers[1] = Integer.parseInt(part1.substring(part1.indexOf('-') + 1));
        numbers[2] = Integer.parseInt(part2.substring(0, part2.indexOf('-')));
        numbers[3] = Integer.parseInt(part2.substring(part2.indexOf('-') + 1));
        if (numbers[0] >= numbers[2] && numbers[1] <= numbers[3]) {
            return true;
        } else return numbers[2] >= numbers[0] && numbers[3] <= numbers[1];
    }

    public void part2() {
        try {
            Scanner reader = new Scanner(new File("day4input.txt"));
            int numberOfOverlaps = 0;
            while (reader.hasNext()) {
                String line = reader.next();
                String part1 = line.substring(0, line.indexOf(','));
                String part2 = line.substring(line.indexOf(',') + 1);
                if (overlap(part1, part2)){
                    numberOfOverlaps++;
                }
            }
            System.out.println(numberOfOverlaps);
        } catch (FileNotFoundException | RuntimeException e) {
            System.out.println("File reading messed up");
            e.printStackTrace();
        }
    }

    public boolean overlap(String part1, String part2){
        int[] numbers = new int[4];
        numbers[0] = Integer.parseInt(part1.substring(0, part1.indexOf('-')));
        numbers[1] = Integer.parseInt(part1.substring(part1.indexOf('-') + 1));
        numbers[2] = Integer.parseInt(part2.substring(0, part2.indexOf('-')));
        numbers[3] = Integer.parseInt(part2.substring(part2.indexOf('-') + 1));
        if (numbers[0] >= numbers[2] && numbers[0] <= numbers[3]) {
            return true;
        } else return numbers[2] >= numbers[0] && numbers[2] <= numbers[1];

    }
}
