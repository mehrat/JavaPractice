package tanmay.practice;

import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/1/16.
 */
public class RightRotaition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] newArr = rightRotate(a, k);
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(newArr[m]);
        }


    }

    private static int[] rightRotate(int[] arr, int d) {

        int[] newarr = new int[arr.length];
        int j=0;
        int k=0;
        if(arr.length > d) {
             k = arr.length - d;
        }
        for(int i=k; i< arr.length; i++){
            newarr[j++] = arr[i];
        }

        for(int i=0; i <k;i++){
            newarr[j++] = arr[i];
        }
        return newarr;
//        for(int i=0; i <newarr.length;i++){
//            System.out.print(newarr[i]+ " ");
//        }
    }

}
