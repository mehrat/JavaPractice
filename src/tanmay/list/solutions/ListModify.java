package tanmay.list.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanmaymehra on 9/20/16.
 */
public class ListModify {

    public static void main(String[] args) {
        List ls = new ArrayList<Integer>();

        LinkkListNode l0 = new LinkkListNode(6, null);
        LinkkListNode l1 = new LinkkListNode(5, l0);
        LinkkListNode l2 = new LinkkListNode(4, l1);
        LinkkListNode l3 = new LinkkListNode(3, l2);
        LinkkListNode l4 = new LinkkListNode(2, l3);
        LinkkListNode l5 = new LinkkListNode(1, l4);

        LinkkListNode head = l5;
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
//        LinkkListNode end = l1;
        head =l5;
        while (nodeBtwnHeadAndEnd(head,  findPreviousFromEnd(head)) > 1) {

            LinkkListNode pend = findPreviousFromEnd(head);
            LinkkListNode temp = pend.next;
            pend.next = null;
            LinkkListNode temp2 =  head.next;
            head.next = temp;
            head.next.next = temp2;
            head = head.next.next;

        }

        LinkkListNode origHead = l5;
        while(origHead != null){
            System.out.println(origHead.val);
            origHead = origHead.next;
        }


    }

    private static LinkkListNode findPreviousFromEnd(LinkkListNode head) {
        LinkkListNode temp =head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    static int nodeBtwnHeadAndEnd(LinkkListNode head, LinkkListNode end) {
        int i = 0;
        LinkkListNode temp = head;
        while (temp != end) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    static class LinkkListNode {
        int val;
        LinkkListNode next;

        public LinkkListNode(int val, LinkkListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
