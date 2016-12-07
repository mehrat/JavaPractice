package tanmay.practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/1/16.
 */
public class SparseArrays {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Object, Integer> stringMap = new HashMap();
        for (int i = 0; i < n; i++) {
            String value = s.next();
            int k = 1;
            if (stringMap.containsKey(value.hashCode())) {
                k = stringMap.get(value.hashCode());
                k++;
            }
            stringMap.put(value.hashCode(), k);
        }
        int d = s.nextInt();
        for (int i = 0; i < d; i++) {
            String q = s.next();
            if(stringMap.containsKey(q.hashCode())){
                System.out.println(stringMap.get(q.hashCode()));
            }else{
                System.out.println(0);
            }
        }
    }
}
