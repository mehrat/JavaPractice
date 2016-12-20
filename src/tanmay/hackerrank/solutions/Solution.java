package tanmay.hackerrank.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/12/16.
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/hackerrank/solutions/test.txt");
        Scanner s = new Scanner(file);
//
//        int n;
//
//        int i,x,y;
//         long min_x = x, max_x = x;
//         long min_y = y, max_y = y;
//        for( i = 1; i < n; i++ )
//        {
//            if( x < min_x)
//                min_x = x;
//            else if( x > max_x )
//                max_x = x;
//
//            if( y < min_y )
//                min_y = y;
//            else if( y > max_y )
//                max_y = y;
//        }
//         long side = max_x - min_x;
//        if( side < max_y-min_y )
//            side = max_y-min_y;

        int[] a = {0,2};
        int[] b = {2,0};


        System.out.println(sq(a,b,4));



    }

    private static int findGCD(int number1, int number2) {
        if(number2 == 0){ return number1; } return findGCD(number2, number1%number2); }


    private static long sq(int[] x, int[] y,int k ){

        int n = x.length;

        int i=0;

            int xx = x[0];
            int yy = y[0];

            int min_x = xx, max_x = xx;
            int min_y = yy, max_y = yy;
            for (i = 1; i < n; i++) {
                if (x[i] < min_x) {
                    min_x = x[i];
                } else if (x[i] > max_x) {
                    max_x = x[i];
                }

                if (y[i] < min_y)
                    min_y = y[i];
                else if (y[i] > max_y)
                    max_y = y[i];
            }


        System.out.println(min_x+" "+max_x);

        long side = max_x - min_x;

        int l = x.length -k;

        for (i = 0; i < n; i++) {
            while(k !=0) {
                if(min_x != x[i] && min_y !=y[i]){
                    k++;
                }
                if(max_x != x[i] && max_y !=y[i]){
                    k++;
                }
                if (min_x == x[i]) {
                    min_x = min_x - 1;
                    k--;
                }
                if (max_x == x[i]) {
                    max_x = max_x + 1;
                    k--;
                }
                if (min_y == x[i]) {
                    min_y = min_y - 1;
                    k--;
                }
                if (max_y == y[i]) {
                    max_y = max_y + 1;
                    k--;
                }
            }
        }

        if( side < max_y-min_y ) {
            side = max_y - min_y;
        }


        return side*side;

    }



    private static String IsP(int a, int b, int c, int d){

        if(findGCD(a,b) == findGCD(c,d)){
            return "Yes";
        } else {
            return "No";
        }

    }
}
