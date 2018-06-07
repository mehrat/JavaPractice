package tanmay.practice;

import java.util.LinkedList;
import java.util.List;

public class TestRec {

    public static void main(String[] args) {
        List<String> ll = new LinkedList<String>();
        addToList(ll, 5);
    }

    private static void addToList(List<String> ll, int in) {

        String tt = "tattata";

        System.out.println(tt.indexOf('w'));

        if (in == 0) {
            return;
        } else {
            ll.add(String.valueOf(in));
            addToList(ll, in - 1);
        }


    }

}


