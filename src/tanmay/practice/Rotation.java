package tanmay.practice;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tanmaymehra on 10/22/16.
 */
public class Rotation {

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

        Set strSet = new HashSet<String>();
        StringBuilder sb = new StringBuilder(st);

        int l = st.length();

        for(int i =0; i<st.length(); i++){
            String sttt = st.substring(l-1,l) + st.substring(0,l-1);
            st = sttt;
            strSet.add(sttt);
        }
        System.out.println(strSet.size());
    }
}
