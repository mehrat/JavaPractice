package tanmay.practice;

import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/1/16.
 */
public class LeftRotation {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int d = s.nextInt();

        int[] arr = new int[n];

        for(int i=0; i< n; i++){
            arr[i] = s.nextInt();
        }

        leftRotate(arr, d);
    }

    private static void leftRotate(int[] arr, int d) {

        int[] newarr = new int[arr.length];
        int j=0;
        for(int i=d; i< arr.length; i++){
            newarr[j++] = arr[i];
        }

        for(int i=0; i <d;i++){
            newarr[j++] = arr[i];
        }

        for(int i=0; i <newarr.length;i++){
            System.out.print(newarr[i]+ " ");
        }
    }


}
