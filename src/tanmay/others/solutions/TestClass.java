package tanmay.others.solutions;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] arr = new int[3];
        for(int i=0;i<N;i++){
            arr[i]=s.nextInt();
        }
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            char c = s.next().trim().charAt(0);
            int a = s.nextInt();
            int b = s.nextInt();
            if(c=='C' || c=='c'){
                System.out.println(callCFunc(a-1,b-1, arr));
            }
        }

    }

    private static int callCFunc(int x, int y, int[] arr) {
        int sum =0;

        for(int k=x;k<=y;k++){
            sum = sum + func(arr[k]);
        }
        return sum;
    }

    public static int func(int x){
        if(x==0){
            return 0;
        }
        int sum =0;
        for(int i=1; i<=x; i++){
            sum = sum + calculateGCD(i,x);
        }
        System.out.println(sum);
        return sum;
    }
    public static int calculateGCD(int num1, int num2){
        if(num2 ==0){
            return num1;
        }
        return calculateGCD(num2, num1%num2);
    }
}
