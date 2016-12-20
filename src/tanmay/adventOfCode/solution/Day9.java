package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/9/16.
 */
public class Day9 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day9.txt");
        Scanner s = new Scanner(file);

        String st = s.nextLine();
//
//        char[] arr = st.toCharArray();
//        int ind = st.indexOf('(');
//
//        StringBuffer stb = new StringBuffer(st.substring(0, ind));
//
//        for (int i = 0; i < arr.length - 7; i++) {
//            if (arr[i] == '(') {
//                int j = i + 1;
//                while (arr[j] != 'x') {
//                    j++;
//                }
//                int n = Integer.parseInt(st.substring(i + 1, j));
//                int k = j + 1;
//                while (arr[k] != ')') {
//                    k++;
//                }
//                int times = Integer.parseInt(st.substring(j + 1, k));
//                String temp = st.substring(k + 1, k + n + 1);
//                while (times != 0) {
//                    stb.append(temp);
//                    times--;
//                }
//                i = k + n;
//            }
//
//        }

//        System.out.println(stb.toString());
//        System.out.println(stb.length());


        long sum = 0;
        sum = part2Recursion(st, 1);
        System.out.println(sum);
    }

    private static long part2Recursion(String st, int tim) {

        char[] arr = st.toCharArray();
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                int j = i + 1;
                while (arr[j] != 'x') {
                    j++;
                }
                int n = Integer.parseInt(st.substring(i + 1, j));
                int k = j + 1;
                while (arr[k] != ')') {
                    k++;
                }
                int times = Integer.parseInt(st.substring(j + 1, k));
                String temp = st.substring(k + 1, k + n + 1);

                if (temp.contains("(")) {
                    times = times * tim;
                    sum = sum + part2Recursion(temp, times);
                } else {
                    sum = sum + (n * times * tim);
                }
                i = k + n;
            }

        }
        if (sum < 0) {
            System.out.println();
        }
        return sum;
    }
}

