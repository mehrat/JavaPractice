package tanmay.practice;

import java.util.ArrayList;
import java.util.List;

public class Atlastest {

    public static void main(String[] args) {
        System.out.println(compute("PMLPMMMLPMLPMML"));
        System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));

    }

    private static String compute(String instructions) {
        List<Long> count = new ArrayList<>(10);
        for (int i=0;i<10; i++) {
            count.add(0L);
        }
        int current = 0;
        boolean holding = false;
        for (int i=0; i<instructions.length(); i++) {
            char command = instructions.charAt(i);
            if (command == 'P') {
                holding = true;
                current = 0;
            }
            else if (command == 'M') {
                current++;
            }
            else if (command == 'L') {
                if (!holding) {
                    continue;
                }
                if (current > 9) {
                    current = 9;
                }
                if (count.get(current) < 15) {
                    long cnt = count.get(current);
                    count.set(current, cnt+1);
                    holding = false;
                }
            }
        }
        String result = "";
        for (int i=0; i<10; i++) {
            if (count.get(i) > 9) {
                char c = 'A';
                c += count.get(i)%10;
                result += c;
            }
            else {
                result += count.get(i);
            }
        }
        return result;
    }
}
