package tanmay.adventOfCode.solution;

/**
 * Created by tanmaymehra on 12/19/16.
 */
public class CircularList {
    Link first;
    Link last;

    public CircularList() {
        first = null;
        last = null;
    }

    public int size(){
        Link temp = first;
        int n=0;
        while(temp !=last){
            n++;
            temp = temp.next;
        }
        return ++n;
    }

    public Link find(long key) {
        Link current = first;
        while(current.data != key) {
            current = current.next;
        }
        return current;
    } // end find

    public boolean isEmpty() { return (first == null); }

    public void insert(long val) {
        Link newLink = new Link(val);

        if(isEmpty())
            last = newLink;

        newLink.next = first;
        first = newLink;
        last.next = first;
    } // end insert

    public void displayAmount(int n) {
        Link current = first;
        while(n>0) {
            current.displayLink();
            current = current.next;
            n--;
        }
        System.out.println("");
    } // end displayAmount

    public Link delete(Link link) {
        if(first.next == null)
            last = null;
        Link temp = link;
        first = link.next;
        if(last != null)
            last.next = first;
        return temp;
    }

}  // end class

class Link {
    public long data;
    public Link next;

    public Link(long val) {
        data = val;
        next = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

}  // end class
