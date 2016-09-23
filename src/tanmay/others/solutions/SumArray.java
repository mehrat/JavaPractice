package tanmay.others.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanmaymehra on 9/17/16.
 */
public class SumArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int test = Integer.parseInt(line);

        List result = new ArrayList<Integer>();

        for(int i=0;i<test;i++) {
            String line2 = br.readLine();
            int N = Integer.parseInt(line2);
            int[] arr = new int[N];
            String[] val = br.readLine().split(" ");
            for(int k=0;k<val.length;k++) {
                System.out.println(val[k]);
            }
            System.out.println("val  "+ val.length);
            if(N>0 && val.length!=0){



            for(int j=0;j<val.length;j++) {
                if(val[j]!=null && val[j]!="\\\\s+") {
                    arr[j] = Integer.parseInt(val[j]);
                }
            }
            int res1 = maxContiguousSubArray(arr);
            int res2 = maxsumNonContiguous(arr);
            result.add(res1);
            result.add(res2);

            }
        }
        for(int i=0;i<result.size();i=i+2) {
            System.out.println(result.get(i)+" "+result.get(i+1));
        }


    }
    public static int maxsumNonContiguous(int[] array){
        if(array == null)
            return 0;

        int arrayLength = array.length;
        int sum1 = array[0];
        int sum2 = 0;

        for(int i = 1; i  <  arrayLength; i++){

            int sum3 = Math.max(sum1,sum2);

            sum2 = sum3;

            sum1 = sum2 + array[i];
        }

        return Math.max(sum1, sum2);
    }
    public static int maxContiguousSubArray(int[] A) {
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        return max;
    }
}
