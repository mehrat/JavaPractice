package tanmay.list.solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by tanmaymehra on 4/18/16.
 */
public class SortProblem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        IntStream.range(0,n).forEach(
                i -> arr[i]= s.nextInt()
        );

        if(checkIfSwapWorks(arr)){

        }
        else if(checkIfReverseWorks(arr)){

        }
    }

    private static boolean checkIfReverseWorks(int[] arr) {
        return false;
    }

    private static boolean checkIfSwapWorks(int[] arr) {
        boolean isSorted = false;
        for(int i=1; i< arr.length; i++){
            if(arr[i]< arr[i-1]){

            }
            else{
                isSorted = true;
            }
        }

        return false;
    }

    private static boolean isSorted(int[] arr){

        //for(int i)
        return false;
    }
}
