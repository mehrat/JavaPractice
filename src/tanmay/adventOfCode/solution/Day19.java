package tanmay.adventOfCode.solution;

import java.util.List;

/**
 * Created by tanmaymehra on 12/19/16.
 */
public class Day19 {

    public static void main(String[] args) {
        int n = 5;

        CircularList elves = new CircularList();

        for (long i = n; i >= 1; i--) {
            elves.insert(i);
        }

        Link pointer = elves.first;

        while (elves.first != elves.last) {

            int delNode = Math.abs(elves.size() / 2);
            Link temp = null;
            Link tempPoint = pointer;
            while (delNode != 1) {
                temp = tempPoint.next;
                tempPoint = tempPoint.next;
                delNode--;
            }
            temp = tempPoint.next;
            System.out.println("Deleting" + temp.data);
            if (temp == elves.first) {
                elves.first = temp.next;
            }
            if (temp == elves.last) {
                elves.last = tempPoint;
            }
            tempPoint.next = temp.next;
            pointer = pointer.next;
        }

        System.out.println(elves.first.data);


    }
}

