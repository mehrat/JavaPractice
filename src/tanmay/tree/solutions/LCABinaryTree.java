package tanmay.tree.solutions;

public class LCABinaryTree {

    public static void main(String[] args) {



    }

    private Node lca(Node root, int v1, int v2) {

        if (root.data == v1 || root.data == v2) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
