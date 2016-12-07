package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day3 {

    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day3.txt");
//        Scanner s = new Scanner(file);
//        int n = 0;
//
//        while (s.hasNext()) {
//            int a = s.nextInt();
//            int b = s.nextInt();
//            int c = s.nextInt();
//
//            if (isValidTriangle(a, b, c)) {
//                n++;
//            }
//        }
//        System.out.println(n);

   part2();
    }

    private static boolean isValidTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

    private static void part2() throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day3.txt");
        Scanner s = new Scanner(file);
        int n = 0;


        while(true) {
            int a1 = s.nextInt();
            int b1 = s.nextInt();
            int c1 = s.nextInt();

            int a2 = s.nextInt();
            int b2 = s.nextInt();
            int c2 = s.nextInt();

            int a3 = s.nextInt();
            int b3 = s.nextInt();
            int c3 = s.nextInt();
            if (isValidTriangle(a1, a2, a3)) {
                n++;
            }
            if (isValidTriangle(b1, b2, b3)) {
                n++;
            }
            if (isValidTriangle(c1, c2, c3)) {
                n++;
            }
//            a1 = a2;
//            b1 = b2;
//            c1 = c2;
//            a2 = a3;
//            b2 = b3;
//            c2 = c3;
            if(!s.hasNext()){
                break;
            }
//            a3 = s.nextInt();
//            b3 = s.nextInt();
//            c3 = s.nextInt();
        }
        System.out.println(n);
    }
}
