package tanmay.tree.solutions;

/**
 * Created by tanmaymehra on 4/28/16.
 */
public class TreeTopView extends Node {
    public static void main(String[] args) {

       Node root = buildATree();

        leftTopView(root);
        rightTopView(root.right);
    }


    private static void rightTopView(Node root) {

        if(root == null){
            return;
        }
        System.out.println(root.data);
        rightTopView(root.right);
    }

    private static void leftTopView(Node root) {

        if(root == null){
            return;
        }
        leftTopView(root.left);
        System.out.println(root.data);
    }
}
