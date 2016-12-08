package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/8/16.
 */
public class Day8 {

    public static void main(String[] args) throws FileNotFoundException {

        int[][] mat = new int[6][50];

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day8.txt");
        Scanner s = new Scanner(file);

        while (s.hasNextLine()) {
            String st = s.nextLine();

            if (st.substring(0, 4).equals("rect")) {
                int in1 = st.indexOf(" ");
                int in2 = st.indexOf("x");
                int i = Integer.parseInt(st.substring(in1+1, in2));
                int j = Integer.parseInt(st.substring(in2 + 1, st.length()));
                rect(mat, i, j);
            }else
            if (st.substring(0, 10).equals("rotate row")) {
                int in1 = st.indexOf('=');
                String[] arr = st.split(" ");
                int row = Integer.parseInt(st.substring(in1+1, in1 + 2));
                int shift = Integer.parseInt(arr[arr.length - 1]);
                rowRotate(mat, row, shift);
            }else
            if (st.substring(0, 13).equals("rotate column")) {
                String[] arr = st.split(" ");
                int col = Integer.parseInt(arr[2].substring(2, arr[2].length()));
                int shift = Integer.parseInt(arr[4]);
                colRotate(mat, col, shift);
            }
            System.out.println(st);
            printArr(mat);
            System.out.println();
        }
        int n=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(mat[i][j]+ " ");
                if(mat[i][j]==1){
                    n++;
                }
            }
            System.out.println();
        }

        System.out.println(n);
    }

    private static void printArr(int[][] arr){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void colRotate(int[][] mat, int col, int shift) {
        while(shift!=0) {
            int k = mat[5][col];
            for (int i = 5; i > 0; i--) {
                    mat[i][col] = mat[i-1][col];
            }
            mat[0][col] = k;
            shift--;
        }
    }

    private static void rowRotate(int[][] mat, int row, int shift) {
        int[] arr = mat[row];
        while (shift != 0) {
            int k = arr[49];
            for (int i = 49; i > 0; i--) {
                arr[i] = arr[i-1];
            }
            arr[0]=k;
            shift--;
        }

        for(int i = 0; i < 50; i++){
            mat[row][i] = arr[i];
        }

    }

    private static void rect(int[][] mat, int i, int j) {
        for (int x = 0; x <= j-1; x++) {
            for (int y = 0; y <= i-1; y++) {
                mat[x][y] = 1;
            }
        }
    }
}
