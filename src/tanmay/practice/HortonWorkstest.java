package tanmay.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HortonWorkstest {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/practice/hrinput.txt");
        Scanner s = new Scanner(file);
//        String n = s.next();
//        int k = s.nextInt();
//
//        System.out.println(n);
//        System.out.println(k);
        System.out.println(LookAndSay("11",2));

    }

    private static String LookAndSay(String number, int s) {
        for (int i=0;i<s;i++) {

            StringBuilder stringBuilder= new StringBuilder();

            char r= number.charAt(0);
            number = number.substring(1) + " ";
            int noOfTimes= 1;

            for(char actual: number.toCharArray()){
                if(actual != r){
                    stringBuilder.append(noOfTimes).append("").append(r);
                    noOfTimes= 1;
                    r= actual;
                }else{
                    noOfTimes+= 1;
                }
            }
            number = stringBuilder.toString();
        }
        return number;
    }

    private static String LookAndSayOneTime(String number) {
        StringBuilder result= new StringBuilder();

        char repeat= number.charAt(0);
        number= number.substring(1) + " ";
        int times= 1;

        for(char actual: number.toCharArray()){
            if(actual != repeat){
                result.append(times).append("").append(repeat);
                times= 1;
                repeat= actual;
            }else{
                times+= 1;
            }
        }
        return result.toString();
    }


}

