package tanmay.tree.solutions;

/**
 * Created by tanmaymehra on 4/24/16.
 */
public class KthSmallestBST extends Node {



    public static void main(String[] args) {

        Node root = new Node(20);
        insertBST(8, root);
        insertBST(4, root);
        insertBST(12, root);
        insertBST(10, root);
        insertBST(14, root);
        insertBST(22, root);

        for (int i = 1; i <= 5; i++) {
            System.out.println(findKthSmallest(root, i));
        }
    }

    private static int findKthSmallest(Node root, int k) {

        if (root == null) {
            return 0;
        }
        int left_no = findLeftSubTreeLen(root.left);
        if (left_no == k - 1) {
            return root.data;
        } else if (left_no > k - 1) {
            return findKthSmallest(root.left, k);
        } else {
            return findKthSmallest(root.right, k);
        }
    }

    private static int findLeftSubTreeLen(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + findLeftSubTreeLen(root.left) + findLeftSubTreeLen(root.right);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(){
    }

    Node(int val) {
        this.data = val;
    }

    public static Node insertBST(int value, Node root) {
        Node node = new Node(value);
        Node temproot = root;
        boolean inserted = false;
        while (!inserted) {

            if (value <= temproot.data) {
                if (temproot.left == null) {
                    temproot.left = node;
                    inserted = true;
                } else {
                    temproot = temproot.left;
                }
            } else {
                if (temproot.right == null) {
                    temproot.right = node;
                    inserted = true;
                } else {
                    temproot = temproot.right;
                }
            }
        }
        return root;
    }
    public static Node buildATree() {

        Node root = new Node(20);
        insertBST(8, root);
        insertBST(4, root);
        insertBST(12, root);
        insertBST(10, root);
        insertBST(14, root);
        insertBST(22, root);
        return root;
    }
}