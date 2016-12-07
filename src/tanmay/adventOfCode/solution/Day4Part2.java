package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day4Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day4Part2.txt");
        Scanner s = new Scanner(file);
        char first[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        while (s.hasNext()) {
            String st = s.next();
            int in = st.lastIndexOf('-');
            int i1 = st.indexOf('[');
            int val = Integer.parseInt(st.substring(in + 1, i1));
            int rem = val % 26;
            String sub = st.substring(0,in);
            char[] charArr = sub.toCharArray();
            char[] result = new char[sub.length()];
            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                char a;
                int ind=-1;
                for(int k=0;k<26;k++){
                    if(c==first[k]){
                        ind= k;
                        break;
                    }
                }
                if(ind==-1){
                    a=' ';
                }else if(ind+rem <=25){
                    a = first[ind+rem];
                }else{
                    int diff = 25-ind;
                    a = first[rem-diff-1];
                }
                result[i] =a;
            }
            if(String.copyValueOf(result).equalsIgnoreCase("northpole object storage")){
                System.out.println(val);
            }
        }
    }


}
