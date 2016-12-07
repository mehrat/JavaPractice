package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/6/16.
 */
public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day6.txt");
        Scanner s = new Scanner(file);
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        HashMap<Character, Integer> map3 = new HashMap();
        HashMap<Character, Integer> map4 = new HashMap();
        HashMap<Character, Integer> map5 = new HashMap();
        HashMap<Character, Integer> map6 = new HashMap();
        HashMap<Character, Integer> map7 = new HashMap();
        HashMap<Character, Integer> map8 = new HashMap();

        while (s.hasNext()) {

            String st = s.next();

            checkAndAddChar(map1, st.charAt(0));
            checkAndAddChar(map2, st.charAt(1));
            checkAndAddChar(map3, st.charAt(2));
            checkAndAddChar(map4, st.charAt(3));
            checkAndAddChar(map5, st.charAt(4));
            checkAndAddChar(map6, st.charAt(5));
            checkAndAddChar(map7, st.charAt(6));
            checkAndAddChar(map8, st.charAt(7));
        }
//        getMax(map1);
//        getMax(map2);
//        getMax(map3);
//        getMax(map4);
//        getMax(map5);
//        getMax(map6);
//        getMax(map7);
//        getMax(map8);

        getMin(map1);
        getMin(map2);
        getMin(map3);
        getMin(map4);
        getMin(map5);
        getMin(map6);
        getMin(map7);
        getMin(map8);


    }

    private static void getMax(HashMap<Character, Integer> map) {

        int max = 0;
        char c = 'a';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        System.out.println(c);
    }

    private static void getMin(HashMap<Character, Integer> map) {

        int min = Integer.MAX_VALUE;
        Character c = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                c = entry.getKey();
            }
        }
        System.out.println(c);
    }

    private static void checkAndAddChar(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            int k = map.get(c) + 1;
            map.put(c, k);
        } else {
            map.put(c, 1);
        }
    }
}
