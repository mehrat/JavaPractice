package tanmay.tree.solutions;

import tanmay.tree.solutions.BSTNode;

/**
 * Created by tanmaymehra on 4/28/16.
 */
public class TreeTopView extends BSTNode {
    public static void main(String[] args) {

        BSTNode root = new BSTNode(20);
        insertBST(8, root);
        insertBST(4, root);
        insertBST(12, root);
        insertBST(10, root);
        insertBST(14, root);
        insertBST(22, root);

        leftTopView(root);
        rightTopView(root.right);



    }

    private static void rightTopView(BSTNode root) {

        if(root == null){
            return;
        }
        System.out.println(root.value);
        rightTopView(root.right);

    }

    private static void leftTopView(BSTNode root) {

        if(root == null){
            return;
        }
        leftTopView(root.left);
        System.out.println(root.value);
    }


}
