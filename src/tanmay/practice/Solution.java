package tanmay.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanmaymehra on 10/22/16.
 */
public class Solution {


    public static void main(String[] args) throws IOException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/practice/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        int M = Integer.parseInt(line);
        List<Family> familySet = new ArrayList<>();
        String foodTyoes = br.readLine();
        String sleepTyoes = br.readLine();

        for (int i = 0; i < M; i++) {
            Family fam = new Family(foodTyoes.charAt(i), Character.getNumericValue(sleepTyoes.charAt(i)));
            familySet.add(fam);
        }
        String line2 = br.readLine();
        int T = Integer.parseInt(line2);

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            getSpacialParty(familySet, Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        }

    }

    private static void getSpacialParty(List<Family> familySet, int start, int end) {

        int sum =0;
        for (int i = start-1; i <= end-1; i++) {
            for(int j = i+1; j <= end-1; j++) {
                if(familySet.get(j).ft == familySet.get(i).ft || familySet.get(j).st == familySet.get(i).st){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}

class Family{
    char ft;
    int st;

    public Family(char ft, int st) {
        this.ft = ft;
        this.st = st;
    }
}