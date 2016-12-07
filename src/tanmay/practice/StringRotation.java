package tanmay.practice;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.Arrays;

/**
 * Created by tanmaymehra on 10/22/16.
 */
public class StringRotation {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/practice/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        for(int i = 0; i < T; i++){
            String st = br.readLine();

            printNumberOfUniqueString(st);

        }

    }

    private static void printNumberOfUniqueString(String st) {

        String sub = lrs(st);
        if(countSubString(st, st.substring(0,1)) == st.length()){
            System.out.println(1);
        }
        else if(sub.length() != st.length() && sub.length() > 0 && checkSub(st, sub)){
            System.out.println(sub.length());
        }
        else{
            System.out.println(st.length());
        }
    }

    private static boolean checkSub(String st, String sub) {
        int c = countSubString(st,sub);

        if(c*sub.length() == st.length()){
            return true;
        }
        return false;
    }

    private static int countSubString(String st, String subst){
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = st.indexOf(subst,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += subst.length();
            }
        }
        return count;
    }

    public static String lrs(String s) {

        // form the N suffixes
        int n  = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i, n);
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < n-1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }

    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }

}
