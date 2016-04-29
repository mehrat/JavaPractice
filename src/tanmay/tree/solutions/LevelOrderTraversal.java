package tanmay.tree.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tanmaymehra on 4/28/16.
 */
public class LevelOrderTraversal extends Node {


    public static void main(String[] args) {

        Node root = buildATree();
        levelorderTraversal(root);
    }

    private static void levelorderTraversal(Node root) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){

            Node temp = queue.poll();
            System.out.println(temp.data);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }

    }

}
