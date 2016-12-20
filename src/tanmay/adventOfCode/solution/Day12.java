package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/12/16.
 */
public class Day12 {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day12.txt");
        Scanner s = new Scanner(file);

        String[] arr = new String[23];
        int i = 0;
        while (s.hasNext()) {
            arr[i++] = s.nextLine();
        }
        int j = 0;
        int a = 0, b = 0, c = 1, d = 0;
        while (j < 23) {
            String cmd = arr[j];
            if (cmd.contains("cpy")) {
                String[] sp = cmd.split(" ");
                try {
                    if (sp[2].equals("a")) {
                        a = Integer.parseInt(sp[1]);
                    }
                    if (sp[2].equals("b")) {
                        b = Integer.parseInt(sp[1]);
                    }
                    if (sp[2].equals("c")) {
                        c = Integer.parseInt(sp[1]);
                    }
                    if (sp[2].equals("d")) {
                        d = Integer.parseInt(sp[1]);
                    }
                } catch (NumberFormatException e){
                    int l=0;
                    if(sp[1].equals("a"))
                    {l=a;} else if(sp[1].equals("b"))
                    {l=b;}else if(sp[1].equals("c"))
                    {l=c;}else if(sp[1].equals("d"))
                    {l=d;}
                    if (sp[2].equals("a")) {
                        a=l;
                    }
                    if (sp[2].equals("b")) {
                        b = l;
                    }
                    if (sp[2].equals("c")) {
                        c = l;
                    }
                    if (sp[2].equals("d")) {
                        d = l;
                    }
                }
            } else if (cmd.contains("inc")) {
                String[] sp = cmd.split(" ");
                if (sp[1].equals("a")) {
                    a++;
                }
                if (sp[1].equals("b")) {
                    b++;
                }
                if (sp[1].equals("c")) {
                    c++;
                }
                if (sp[1].equals("d")) {
                    d++;
                }
            } else if (cmd.contains("dec")) {
                String[] sp = cmd.split(" ");
                if (sp[1].equals("a")) {
                    a--;
                }
                if (sp[1].equals("b")) {
                    b--;
                }
                if (sp[1].equals("c")) {
                    c--;
                }
                if (sp[1].equals("d")) {
                    d--;
                }
            } else if (cmd.contains("jnz")) {
                String[] sp = cmd.split(" ");
                int k = Integer.parseInt(sp[2]);
                if (sp[1].equals("a") && a != 0) {
                    j = j +k-1;
                }
                if (sp[1].equals("b") && b != 0) {
                    j = j +k-1;
                }
                if (sp[1].equals("c") && c != 0) {
                    j = j +k-1;
                }
                if (sp[1].equals("d") && d != 0) {
                    j = j +k-1;
                }
            }
            j++;
        }

        System.out.println(a + " " + b + " " + c + " " + d);

    }
}
