package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day2.txt");
        Scanner s = new Scanner(file);

        int[][] mat = new int[3][3];

        while(s.hasNext()) {
            String st = s.next();
            int x=0;
            int y=0;
            for (int i = 0;i<st.length();i++){
                char c = st.charAt(i);
                if(c=='U' && x !=0){
                    x--;
                }else if(c=='D' && x!=2){
                    x++;
                } else if(c=='R' && y!=2){
                    y++;
                } else if(c=='L' && y!=0){
                    y--;
                }
            }
            System.out.println(x+","+y);

        }
        part2();
    }

    private static void part2() throws FileNotFoundException {

        int[][] multi = new int[][]{
                { 0, 0, 1, 0, 0},
                { 0, 2, 3, 4, 0 },
                { 5, 6, 7, 8, 9 },
                { 0, 11, 12, 13, 0},
                { 0, 0, 14, 0, 0}
        };


        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day2part2.txt");
        Scanner s = new Scanner(file);

        while(s.hasNext()) {
            String st = s.next();
            int x=0;
            int y=2;
            for (int i = 0;i<st.length();i++){
                char c = st.charAt(i);
                if(c=='U' && y-1 >=0 && multi[x][y-1] !=0){
                    y--;
                }else if(c=='D' && y+1 <= 4 && multi[x][y+1] !=0){
                    y++;
                } else if(c=='R' && x+1 <= 4 && multi[x+1][y] !=0){
                    x++;
                } else if(c=='L' && x-1 >= 0 && multi[x-1][y] !=0){
                    x--;
                }
            }
            System.out.println(x+","+y);

        }




    }
}
// 99332