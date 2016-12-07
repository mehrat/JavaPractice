package tanmay.practice;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

/**
 * Created by tanmaymehra on 10/26/16.
 */
public class Palindrom {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        boolean flag = true;

        while (flag) {
            n++;
            if (isPallindrom(n)) {
                flag = false;
            }
        }

        System.out.println(n);
    }

    private static boolean isPallindrom(int n) {
        //1221
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        StringBuilder reverse = sb.reverse();
        if (reverse.toString().equalsIgnoreCase(String.valueOf(n))) {
            return true;
        }
        return false;
    }
}
