package tanmay.test.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by tanmaymehra on 12/1/16.
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/test/solutions/test.txt");
        Scanner s = new Scanner(file);

        String input = s.next();

        validate(input);



    }

    private static void validate(String input) {

        char[] charArr = input.toCharArray();

        int field =0;
        int record = 0;
        int empty =0;
        String lastF;

        boolean fend = false;

        if(input.contains("~~~")){
            System.out.println("0:0:0:format_error");
        }
        String dub = input;
        List<List<String>> l = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        List<String> l2= null;
        while(!fend) {
            int in = dub.indexOf('|');
            String sub = dub.substring(in+1);
            int in2 = sub.indexOf('|');

            String s = dub.substring(in+1,in2+1);
            if(s.equals("~n")){
                dub = dub.substring(in2+1);
                break;
            }
            l1.add(s);
            dub = dub.substring(in2+1);

        }
        l.add(l1);
        while(!fend) {
            int in = dub.indexOf('|');
            String sub = dub.substring(in+1);
            int in2 = sub.indexOf('|');
            if(in2==-1){
                break;
            }
            String s = dub.substring(in+1,in2+1);
            if(l2 == null){
                l2 = new ArrayList<>();
            }
            if(s.equals("~n")){
                l.add(l2);
                l2 = null;
            }
            if(l2 !=null) {
                l2.add(s);
            }
            dub = dub.substring(in2+1);

            if(dub.length()==2 && dub.substring(0,2) == "~n") {
                fend = true;
            }
        }
        field = l.get(0).size();
        record = l.size()-1;
        for(int i = 1; i< l.size();i++){
            List ll = l.get(i);
            if(ll.size() > field){
                field = ll.size();
            }
            for(int j = 0; j< ll.size();j++){
                if(ll.get(j)==""){
                    empty++;
                }
            }
        }
        int k = field - l.get(0).size();
        if(k > 0){
            lastF = l.get(0).get(l.size()-1) + "_"+k;
        }else{
            lastF = l.get(0).get(l.size()-1);
        }
        System.out.println(record+":"+field+":"+empty+":"+lastF);
    }

}
