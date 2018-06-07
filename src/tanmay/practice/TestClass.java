package tanmay.practice;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.Scanner;

class TestClass {


    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while (test != 0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            int i = 0;
            int max = -1;
            for (int g = 0; g < n; g++) {
                arr[i] = s.nextInt();
                if (max < arr[i]) {
                    max = arr[i];
                }
                i++;
            }
            int k = 1;
            while (true) {
                boolean perfect = true;
                for (int j = 0; j < n; j++) {
                    if ((max * k) % arr[j] != 0) {
                        k++;
                        perfect = false;
                        break;
                    } else {
                        perfect = true;
                    }
                }
                if (perfect) {
                    break;
                }
            }

            System.out.println(max * k);
            --test;
        }

    }
}
