package tanmay.graph.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tanmaymehra on 9/23/16.
 */
public class KruskalMSTDSolution {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/graph/solutions/input.txt");
        Scanner s = new Scanner(file);

        int test = s.nextInt();
        while (test != 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] adjancyMat = new int[n][n];

            for (int i = 0; i < m; i++) {
                Vertex first = new Vertex(s.nextInt());
                Vertex second = new Vertex(s.nextInt());
                int weight = s.nextInt();

                Edge edge = new Edge(first, second, weight);

            }
            int node = s.nextInt();
            kruskalImpl(adjancyMat, node);
            test--;
        }
        s.close();
    }

    private static void kruskalImpl(int[][] adjancyMat, int node) {


    }


}

class Vertex {

    int value;

    public Vertex(int value) {
        this.value = value;
    }
}

class Edge {

    Vertex source;
    Vertex destination;
    int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}