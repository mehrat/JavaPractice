import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tanmaymehra on 4/19/16.
 */
public class MaxDist {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[][] adjMat = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0].trim());
                int b = Integer.parseInt(input[1].trim());
                int w = Integer.parseInt(input[2].trim());
                adjMat[a][b] = w;
                adjMat[b][a] = w;
            }
        }
    }


    public static void distanceBetweenLeafNode(int[][] adj, int n, int leaf){

        for(int i =0; i<=n; i++){



        }


    }

}
