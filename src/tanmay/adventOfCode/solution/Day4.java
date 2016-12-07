package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day4.txt");
        Scanner s = new Scanner(file);
        int sum = 0;
        while (s.hasNext()) {
            String st = s.next();
            int in = st.lastIndexOf('-');
            String sub = st.substring(0, in);
            HashMap<Character, Integer> map = getCharFrequency(sub);

            int i1 = st.indexOf('[');
            int i2 = st.indexOf(']');
            boolean flag = true;
            String fre = st.substring(i1 + 1, i2);
            char[] freChar = fre.toCharArray();
            List<Integer> pre = new ArrayList<>(fre.length());
            for (int i = 0; i < fre.length(); i++) {
                char c = fre.charAt(i);
                if (map.containsKey(c)) {
                    int k = map.get(c);
                    pre.add(k);
//                    if (pre.size() == 0) {
//                        pre.add(k);
//                    }
                    int l = pre.stream().min(Integer::compareTo).get();

                    if (k > l) {
                        flag = false;
                        break;
                    }

                } else {
                    flag = false;
                    break;
                }
            }
            for (int i = 0; i < pre.size() - 1; i++) {
                if (pre.get(i) == pre.get(i + 1)) {
                    if (freChar[i] > freChar[i + 1]) {
                        flag=false;
                    }
                }

            }
            if (flag) {
                int val = Integer.parseInt(st.substring(in + 1, i1));
                sum = sum + val;
            }
        }
        System.out.println(sum);
    }

    private static HashMap getCharFrequency(String sub) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if (map.containsKey(c)) {
                Integer k = map.get(c);
                map.put(c, k + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
