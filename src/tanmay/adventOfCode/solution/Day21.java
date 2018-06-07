package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tanmaymehra on 12/21/16.
 */
public class Day21 {

    public static void main(String[] args) throws FileNotFoundException {


        String stt = "fbgdceah";

        Set<String> stset = permutationFinder(stt);
        for(String st : stset) {
            String orig = st;
            char[] arr = st.toCharArray();
            File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day21.txt");
            Scanner s = new Scanner(file);

            while (s.hasNext()) {

                String cmd = s.nextLine();

                String[] cmdSplit = cmd.split(" ");

                if (cmdSplit[0].equals("swap") && cmdSplit[1].equals("position")) {
                    int x = Integer.parseInt(cmdSplit[2]);
                    int y = Integer.parseInt(cmdSplit[5]);
                    char t = arr[x];
                    arr[x] = arr[y];
                    arr[y] = t;
                } else if (cmdSplit[0].equals("swap") && cmdSplit[1].equals("letter")) {
                    int x = st.indexOf(cmdSplit[2]);
                    int y = st.indexOf(cmdSplit[5]);
                    char t = arr[x];
                    arr[x] = arr[y];
                    arr[y] = t;
                } else if (cmdSplit[0].equals("rotate") && cmdSplit[1].equals("left")) {
                    int x = Integer.parseInt(cmdSplit[2]);
                    arr = leftRotate(arr, x);
                } else if (cmdSplit[0].equals("rotate") && cmdSplit[1].equals("right")) {
                    int x = Integer.parseInt(cmdSplit[2]);
                    arr = rightRotate(arr, x);
                } else if (cmdSplit[0].equals("rotate") && cmdSplit[1].equals("based")) {
                    int x = st.indexOf(cmdSplit[6].toCharArray()[0]);
                    int rt = 1 + x;
                    if (x >= 4) {
                        rt = rt + 1;
                    }
                    arr = rightRotate(arr, rt);
                } else if (cmdSplit[0].equals("reverse") && cmdSplit[1].equals("positions")) {
                    int x = Integer.parseInt(cmdSplit[2]);
                    int y = Integer.parseInt(cmdSplit[4]);
                    StringBuilder sb = new StringBuilder(st.substring(x, y + 1));
                    char[] charArr = sb.reverse().toString().toCharArray();
                    int k = 0;
                    for (int i = x; i <= y; i++) {
                        arr[i] = charArr[k];
                        k++;
                    }
                } else if (cmdSplit[0].equals("move") && cmdSplit[1].equals("position")) {
                    int x = Integer.parseInt(cmdSplit[2]);
                    int y = Integer.parseInt(cmdSplit[5]);
                    char c = arr[x];
                    for (int i = x; i < st.length() - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    for (int i = st.length() - 1; i >= y + 1; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[y] = c;
                }

                st = new String(arr);
            }
            if(st.equals(stt)) {
                System.out.println(orig);
            }
        }
    }

    private static char[] leftRotate(char[] arr, int x) {

        int i;
        for (i = 0; i < x; i++)
            leftRotatebyOne(arr, arr.length);

        return arr;
    }

    static void leftRotatebyOne(char arr[], int n) {
        int i;
        char temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    private static char[] rightRotate(char[] arr, int d) {

        char[] newArray = new char[arr.length];

        for (int x = 0; x <= arr.length - 1; x++) {
            newArray[(x + d) % arr.length] = arr[x];
        }

        return newArray;
    }

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }


}
