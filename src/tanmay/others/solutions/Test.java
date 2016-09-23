package tanmay.others.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanmaymehra on 4/30/16.
 */
public class Test {


    public static void main(String[] args) throws IOException {


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        int N = 5;// Integer.parseInt(line);
        String s = "aacbb"; //br.readLine();
//        String qq = br.readLine();
        int q = 2;//Integer.parseInt(qq);

        Query[] arr = new Query[q];
        int l=0;
        for (int i = 0; i < q; i++) {
            String input = "a a"; //br.readLine();
            Query query = new Query(input.charAt(0),input.charAt(2));
            arr[l++] = query;

        }

        if(N < 1){
            for (int i = 0; i < q; i++) {
                System.out.println(1);
            }
        }else { for (int i = 0; i < q; i++) {
            countSubString(s,arr[i]);
        }
        }
    }

    private static void countSubString(String s, Query query) {

        char[] charArr  = s.toCharArray();
        List<Integer> start = new LinkedList<>();
        List<Integer> end = new LinkedList();
        int k=0;
        int g= 0;
        for(int i = 0;i < charArr.length; i++){
            if(charArr[i]==query.a){
                 start.add(i);
            }
            if(charArr[i]==query.b){
                end.add(i);
            }
        }
        int sum =0;
        if(query.a != query.b) {
            for (int i : start) {
                for (int j : end) {
                    if (Math.abs(j - i) >= 1) {
                        sum = sum + 1;
                    }
                }
            }
            System.out.println(sum);
        }else{
            for (int i : start) {
                for (int j : start) {
                    if (Math.abs(j - i) > 1) {
                        sum = sum + 1;
                    }
                }
            }
        }


    }
    static class Query{
        char a;
        char b;

        Query(char a, char b){
            this.a = a;
            this.b = b;
        }
    }


}

