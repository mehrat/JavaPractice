package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day1 {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day1.txt");
        Scanner s = new Scanner(file);

        int x=0,y=0;
        char direction='N';
        while(true) {

            String st = s.next();
            String dir = st.substring(0,1);
            int in = st.indexOf(',');
            int bloc = Integer.parseInt(st.substring(1,in));

            if(dir.equals("R")){
               if(direction=='W'){
                    direction='S';
                    y = y - bloc;
                }else if(direction=='S'){
                    direction='E';
                    x = x-bloc;
                } else if(direction=='E'){
                    direction='N';
                    y = y+bloc;
                } else if(direction=='N'){
                    direction='W';
                    x = x+bloc;
                }
            }else{
                if(direction=='W'){
                    direction='N';
                    y = y + bloc;
                }else if(direction=='S'){
                    direction='W';
                    x = x+bloc;
                } else if(direction=='E'){
                    direction='S';
                    y = y-bloc;
                } else if(direction=='N'){
                    direction='E';
                    x = x-bloc;
                }
            }


            if(!s.hasNext()){
                break;
            }
        }

        System.out.println(x);
    }
}
