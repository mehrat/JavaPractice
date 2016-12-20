package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by tanmaymehra on 12/20/16.
 */
public class Day20 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day20.txt");
        Scanner s = new Scanner(file);
        List<Long> minValues = new ArrayList<>();
        List<Long> maxValues = new ArrayList<>();

        while (s.hasNext()) {
            String range = s.nextLine();
            int in = range.indexOf('-');
            long r1 = Long.parseLong(range.substring(0, in));
            long r2 = Long.parseLong(range.substring(in + 1, range.length()));
            minValues.add(r1);
            maxValues.add(r2);


        }
//        System.out.println("MIN VALUES");
//        minValues.stream().sorted(Long::compareTo).forEach(System.out::println);
//
//        System.out.println("MAX VALUES");
//        maxValues.stream().sorted(Long::compareTo).forEach(System.out::println);
//
//        Optional<Long> minValue = minValues.stream().min(Long::compareTo);
//        Optional<Long> maxValue = minValues.stream().max(Long::compareTo);

        Collections.sort(minValues);
        Collections.sort(maxValues);

        long n =0;
        long k =0;

        for(int i=1;i< minValues.size(); i++){
                if(minValues.get(i) > maxValues.get(i-1)){

                    n = n + (minValues.get(i)-maxValues.get(i-1));
                    k++;
                    System.out.println(maxValues.get(i-1)+"  "+minValues.get(i));
                }
        }
        System.out.println(k);
        System.out.println(n-k);


    }


}
