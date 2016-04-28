package tanmay.graph.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanmaymehra on 4/17/16.
 */
public class NodeSum {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
       while(t !=0){
           int N = Integer.parseInt(line);
           List<Node> nodes = new LinkedList<Node>();
           String[] strs = line.trim().split("\\s+");
           for (int i = 0; i < N; i++) {
               int num = Integer.parseInt(strs[i]);
               if(!ispresent(nodes, num)) {
                   Node n = new Node(num);
                   nodes.add(n);
                   int num2 = Integer.parseInt(strs[i]);
                   if(!ispresent(nodes, num)){
                       Node n2 = new Node(num2);
                       nodes.add(n2);
                       n.nodes.add(n2);
                       int we = Integer.parseInt(strs[i]);
                       n.w.add(we);
                   }
               }
               else{
                   for(Node nn : nodes){
                       if(nn.n == num){
                           int num2 = Integer.parseInt(strs[i]);
                           if(!ispresent(nodes, num)){
                               Node n2 = new Node(num2);
                               nodes.add(n2);
                               nn.nodes.add(n2);
                               int we = Integer.parseInt(strs[i]);
                               nn.w.add(we);
                           }
                       }
                   }
               }
           }
           calculateSum(nodes);

           t--;
       }

    }

    private static int calculateSum(List<Node> nodes) {



        return 0;
    }

    private static boolean ispresent(List<Node> nodes, int a) {
        for(Node n : nodes){
            if(n.n==a){
                return true;
            }
        }

    return false;
    }
}

 class Node{
    int n;
    List<Node> nodes = new ArrayList<>();
     List<Integer> w = new ArrayList<>();

     Node(int n){
         this.n = n;
     }
}
