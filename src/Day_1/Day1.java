import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public void part1() throws Exception {
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_1/day1input.txt"));
        int max = 0;
        int current = 0;
        while (reader.hasNext()) {
            String str = reader.nextLine();
            if (!str.equals("")) {
                current += Integer.parseInt(str);
            } else {
                if (current > max) max = current;
                current = 0;
            }
        }
        System.out.println("Part 1 Answer: " + max);
    }

    public void part2() throws Exception {
        Scanner reader = new Scanner(new File("/Users/pouyakarimi/Desktop/AdventOfCode_2022/src/Day_1/day1input.txt"));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(0);
        numbers.add(0);
        int current = 0;
        while (reader.hasNext()) {
            String str = reader.nextLine();
            if (!str.equals("")) {
                current += Integer.parseInt(str);
            } else {
                for (int i = 0; i < 3; i++) {
                    if (current > numbers.get(i)) {
                        numbers.remove(2);
                        numbers.add(i, current);
                        break;
                    }
                }
                current = 0;
            }
        }
        System.out.println("Part 2 Answer: " + (numbers.get(0) + numbers.get(1) + numbers.get(2)));
    }

    public static void main(String[] args) throws Exception {
        Day1 day1 = new Day1();
        day1.part1();
        day1.part2();
    }
}
