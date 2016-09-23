package tanmay.graph.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class DijkstraSolution {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/graph/solutions/input.txt");
        Scanner s = new Scanner(file);

        int test = s.nextInt();
        while (test != 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] adjancyMat = new int[n][n];

            for (int i = 0; i < m; i++) {
                int first = s.nextInt();
                int second = s.nextInt();
                int weight = s.nextInt();

                adjancyMat[first - 1][second - 1] = weight;
                adjancyMat[second - 1][first - 1] = weight;
            }
            int node = s.nextInt();
            dijkstraImpl(adjancyMat, node);
            test--;
        }
        s.close();
    }

    private static void dijkstraImpl(int[][] adjancyMat, int node) {

        int[] distance = new int[adjancyMat.length];
        for (int i = 0; i < distance.length; i++) {
            if (i == node - 1) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        Set nodes = new HashSet<Integer>();

        int tempNode = node - 1;
        while (nodes.size() != adjancyMat.length) {
            for (int i = 0; i < distance.length; i++) {

                if (adjancyMat[tempNode][i] != 0 && distance[tempNode]+adjancyMat[tempNode][i] < distance[i]) {
                    distance[i] = distance[tempNode] + adjancyMat[tempNode][i];
                }
            }
            nodes.add(tempNode);
            tempNode = findMinFromDistArray(distance, nodes);
        }
        for (int i = 0; i < distance.length; i++) {
            if(i!=node-1) {
                System.out.print(distance[i]+" ");
            }
        }


    }

    private static int findMinFromDistArray(int[] distance, Set nodes) {

        int index = 0;
        boolean first = true;
        for (int i = 1; i < distance.length; i++) {

            if (!nodes.contains(i) && first) {
                index = i;
                first = false;
            }

            if (!nodes.contains(i) && distance[index] > distance[i]) {
                index = i;
            }
        }

        return index;
    }

}
