package tanmay.tree.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tanmaymehra on 4/28/16.
 */
public class LowestCommonAncestor extends Node {

    public static void main(String[] args) {

        Node root = new Node(20);
        insertBST(8, root);
        insertBST(4, root);
        insertBST(12, root);
        insertBST(10, root);
        insertBST(14, root);
        insertBST(22, root);

        lca(root, 8, 14);
    }

    private static void lca(Node root, int v1, int v2) {

        List<Integer> preorder = new ArrayList<>();
        preorder(root, preorder);
        List<Integer> postorder = new ArrayList<>();
        postorder(root, postorder);

        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);

        Set<Integer> before = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        if (v1 < v2) {
            for (int k : preorder) {
                if (k != v1) {
                    before.add(k);
                } else {
                    break;
                }
            }
            int l = postorder.indexOf(v2);
            while (l + 1 != postorder.size()) {
                if (before.contains(postorder.get(++l))) {
                    common.add(postorder.get(l));
                }
            }
            boolean found = false;
            for (int q = inorder.indexOf(v1) + 1; q < inorder.indexOf(v2); q++) {
                if (common.contains(inorder.get(q))) {
                    System.out.println(inorder.get(q));
                    found = true;
                }
            }

        }
    }

    private static void postorder(Node root, List postorder) {
        if (root == null) {
            return;
        }
        postorder(root.left, postorder);
        postorder(root.right, postorder);
        postorder.add(root.data);

    }

    private static void preorder(Node root, List preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root.data);
        preorder(root.left, preorder);
        preorder(root.right, preorder);
    }

    private static void inorder(Node root, List inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root.data);
        inorder(root.right, inorder);
    }
}
