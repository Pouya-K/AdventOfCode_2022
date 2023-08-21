import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void part1() throws Exception {
        Scanner reader = new Scanner(new File("day1input.txt"));
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
        System.out.println(max);
    }

    public static void part2() throws Exception {
        Scanner reader = new Scanner(new File("day1input.txt"));
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(0);
        nums.add(0);
        nums.add(0);
        int current = 0;
        while (reader.hasNext()) {
            String str = reader.nextLine();
            if (!str.equals("")) {
                current += Integer.parseInt(str);
            } else {
                for(int i = 0; i<3; i++){
                    if(current > nums.get(i)){
                        nums.remove(2);
                        nums.add(i,current);
                        break;
                    }
                }
                current = 0;
            }
        }
        System.out.println(nums.get(0) + nums.get(1) + nums.get(2));
    }

    public static void main(String[] args) throws Exception {
        part1();
        part2();
    }
}
