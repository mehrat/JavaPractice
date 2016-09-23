package tanmay.others.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tanmaymehra on 4/30/16.
 */
public class TestFunction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N =  Character.getNumericValue(line.charAt(0));
        int q = Character.getNumericValue(line.charAt(2));
        int[] arr = new int[N];
        String input = br.readLine();
        int l =0;
        for (int i = 0; i <= 2*(N-1); i=i+2) {
            arr[l++] = Character.getNumericValue(input.charAt(i));
        }

        for (int i = 0; i < q; i++) {
            String qq = br.readLine();
            if(qq.length()== 3){
                int a = Character.getNumericValue(qq.charAt(2));
                func1(arr,a);
            }else {
                int a = Character.getNumericValue(qq.charAt(2));
                int b = Character.getNumericValue(qq.charAt(4));
                arr[a]=b;
                //func2(arr,a,b);

            }
        }




    }

//    private static void func2(int[] arr, int a, int b) {
//        arr[a]==b;
//
//    }

    private static void func1(int[] arr, int a) {
        for(int i =0; i<arr.length;i++){
            if(arr[i] >= a){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("-1");
    }
}
