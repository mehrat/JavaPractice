package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 12/22/16.
 */
public class Day22 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day22.txt");
        Scanner s = new Scanner(file);
        List<GridNode> nodeList = new ArrayList<>();

        HashMap<GridNode, GridNode> pairs = new HashMap<>();

        while (s.hasNext()) {
            String st = s.nextLine();
            String[] arr = st.split("\\s+");
            int x = Integer.parseInt(arr[0].substring(arr[0].indexOf('x') + 1, arr[0].indexOf('y') - 1));
            int y = Integer.parseInt(arr[0].substring(arr[0].indexOf('y') + 1, arr[0].length()));
            int size = Integer.parseInt(arr[1].substring(0, arr[1].indexOf('T')));
            int used = Integer.parseInt(arr[2].substring(0, arr[2].indexOf('T')));
            int avail = Integer.parseInt(arr[3].substring(0, arr[3].indexOf('T')));
            int percent = Integer.parseInt(arr[4].substring(0, arr[4].indexOf('%')));

            GridNode node = new GridNode(x, y, size, used, avail, percent);
            nodeList.add(node);
        }
        int n = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.size(); j++) {
                if (nodeList.get(i).used == 0) {
                    break;
                }
                if (nodeList.get(i).x != nodeList.get(j).x && nodeList.get(i).y != nodeList.get(j).y && nodeList.get(i).used <= nodeList.get(j).avail) {
                    pairs.put(nodeList.get(i), nodeList.get(j));
                    n++;
                }
            }
        }
//879
//679
//        System.out.println(n);
part2(nodeList,pairs);
    }


    private static void part2(List<GridNode> nodeList, HashMap<GridNode, GridNode> pairs) {

        int x1 = 0, y1 = 0, x2 = 31, y2 = 0;

        String[][] matrix = new String[28][32];

        for (GridNode node : nodeList) {
            if (node.percent == 0) {
                matrix[node.y][node.x] = "_"+node.used+"/"+node.size;
            } else if (node.x == 31 && node.y == 0) {
                matrix[node.y][node.x] = "G"+node.used+"/"+node.size;
            } else if(node.percent > 85){
                matrix[node.y][node.x] = "#"+node.used+"/"+node.size;
            }
            else {
                matrix[node.y][node.x] = "."+node.used+"/"+node.size;
            }

        }
        //61
        //39
        //194 is low
        //199
        //216
//        for (int j = 0; j < 28; j++) {
//            System.out.print(j);
//        }
        System.out.println();
        for (int i = 0; i < 28; i++) {
//            System.out.print(i);
            for (int j = 0; j < 32; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

//29
    }
}


class GridNode {
    int x, y;
    int size;
    int used;
    int avail;
    int percent;

    public GridNode(int x, int y, int size, int used, int avail, int percent) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.used = used;
        this.avail = avail;
        this.percent = percent;
    }
}