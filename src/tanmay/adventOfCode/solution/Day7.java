package tanmay.adventOfCode.solution;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by tanmaymehra on 12/7/16.
 */
public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day7.txt");
//        Scanner s = new Scanner(file);
//        int n = 0;
//        while (s.hasNext()) {
//            String st = s.next();
//            boolean flag = false;
//            while (st.length() > 0) {
//
//                int i1 = st.indexOf('[');
//                int i2 = st.indexOf(']');
//                if (i1 == -1) {
//                    i1 = st.length();
//                }
//                if (isValid(st.substring(0, i1))) {
//                    flag = true;
//                }
//                if (i2 == -1) {
//                    break;
//                }
//                if (isValid(st.substring(i1 + 1, i2))) {
//                    flag = false;
//                    break;
//                }
//                st = st.substring(i2 + 1, st.length());
//            }
//            if (flag) {
//                n++;
//            }
//
//        }
//        System.out.println(n);
        part2();
    }

    private static boolean isValid(String substring) {
        for (int i = 0; i < substring.length() - 3; i++) {
            if (substring.charAt(i) == substring.charAt(i + 3) && substring.charAt(i + 1) == substring.charAt(i + 2)) {
                if (!(substring.charAt(i) == substring.charAt(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void part2() throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day7.txt");
        Scanner s = new Scanner(file);
        int n = 0;
        while (s.hasNext()) {
            String st = s.next();
            List<String> list = new ArrayList<>();
            List<String> braList = new ArrayList<>();
            while (st.length() > 0) {

                int i1 = st.indexOf('[');
                int i2 = st.indexOf(']');
                if (i1 == -1) {
                    i1 = st.length();
                }
                getValidPart2(st.substring(0, i1), list);
                if (i2 == -1) {
                    break;
                }
                braList.add(st.substring(i1 + 1, i2));
                st = st.substring(i2 + 1, st.length());
            }
            if (isValidPart2(braList, list)) {
                n++;
            }

        }
        System.out.println(n);

    }

    private static boolean isValidPart2(List<String> braList, List<String> list) {
        for (String st : list) {
            String nst = st.substring(1, 2) + st.substring(0, 1) + st.substring(1, 2);
            for (String bra : braList) {
                if (bra.contains(nst)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void getValidPart2(String substring, List list) {
        for (int i = 0; i < substring.length() - 2; i++) {
            if (substring.charAt(i) == substring.charAt(i + 2) && substring.charAt(i) != substring.charAt(i + 1)) {
                list.add(substring.substring(i, i + 3));
            }
        }
    }

}
