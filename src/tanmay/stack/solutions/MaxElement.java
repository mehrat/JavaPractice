package tanmay.stack.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tanmaymehra on 9/23/16.
 */
public class MaxElement {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/stack/solutions/input.txt");
        Scanner s = new Scanner(file);
        Stack stack = new Stack();
        int max = 0;

        int t = s.nextInt();
        for (int i = 0; i < t - 1; i++) {
            int q = s.nextInt();
            if (q == 1) {
                addTostack(s.nextInt(), stack, max);
            } else if (q == 2) {

                deleteFromStackAndSetMax(stack, max);
            } else if (q == 3) {

                System.out.println(max);
            }
        }
    }

    private static void deleteFromStackAndSetMax(Stack stack, int max) {
        if (stack.isEmpty()) {
            return;
        }
        if ((Integer) stack.peek() == max) {
            
        }
    }

    private static void addTostack(int i, Stack stack, int max) {

        if (stack.isEmpty()) {
            max = i;
        }
        if (max < i) {
            max = i;
        }
        stack.push(i);
    }
}
