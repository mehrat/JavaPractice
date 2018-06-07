package tanmay.practice;

import java.util.ArrayList;
import java.util.List;

public class SerializeBinaryTree {

    public static List<Integer> serializeBST(BTNode root, List<Integer> btList) {
        if (root == null) {
            btList.add(-1);
            return btList;
        }
        btList.add(root.data);
//        System.out.println(root.data);
        serializeBST(root.left, btList);
        serializeBST(root.right, btList);
        return btList;
    }

    public static void main(String[] args) {
        BTNode btNode = new BTNode(20);
        int[] nums = {15, 200, 25, 0, 100, 12, 126, 1000};
        for (int i : nums) {
            btNode.addNode(i);
        }

        List<Integer> ll = new ArrayList<>();
        ll = serializeBST(btNode, ll);
//        ll.forEach(System.out::println);
        Pair pair = deserializeBT(ll, 0);

        System.out.println(pair.node.data + " " + pair.node.left.data + " " + pair.node.right.data);

    }

    private static Pair deserializeBT(List<Integer> ll, int ind) {
        if (ll.get(ind) == -1) {
            return new Pair(null, ind + 1);
        }

        BTNode node = new BTNode(ll.get(ind));

        Pair left = deserializeBT(ll, ind + 1);
        node.left = left.node;

        Pair right = deserializeBT(ll, left.nextIndex);
        node.right = right.node;

        return new Pair(node, right.nextIndex);
    }


}

class Pair {
    BTNode node;
    int nextIndex;

    public Pair(BTNode node, int nextData) {
        this.node = node;
        this.nextIndex = nextData;
    }
}


class BTNode {
    Integer data;
    BTNode left;
    BTNode right;

    public BTNode(int data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BTNode(int num) {
        this.data = num;
    }

    public void addNode(int num) {
        if (num < this.data) {
            if (this.left != null) {
                this.left.addNode(num);
            } else {
                this.left = new BTNode(num);
            }

        } else {
            if (this.right != null) {
                this.right.addNode(num);
            } else {
                this.right = new BTNode(num);
            }
        }
    }
}