package tanmay.others.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by tanmaymehra on 7/8/16.
 */
public class DecTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int M = Integer.parseInt(line);
        String line2 = br.readLine();
        int N = Integer.parseInt(line2);

        int[][] matrix = new int[M][N];


        for (int i = 0; i < M; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(val[j]);

            }
        }

        Set<Pos> track = new HashSet<>();
        int sum =0;
        List sumList = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    if(track.isEmpty()){
                        sum++;
                    }
                    if (i+1 <M  && matrix[i + 1][j] == 1) {
                        Pos p = new Pos(i+1,j);
                        if(track.add(p)){
                            sum++;
                        }

                    } else if( j+1 <N && matrix[i][j+1] == 1){
                        Pos p1 = new Pos(i,j+1);
                        if(track.add(p1)){
                            sum++;
                        }

                    }else if(i+1<M && j+1 <N && matrix[i+1][j+1]==1){
                        Pos p2 = new Pos(i+1,j+1);
                        if(track.add(p2)){
                            sum++;
                        }
                    }
                    else{
                        sumList.add(sum);
                        sum =0;
                        track.clear();
                    }
                }
            }
        }

//        Optional<Integer> max = sumList.stream().max(Comparator.naturalOrder());


        Integer max = Integer.MIN_VALUE;
        for(int i=0; i<sumList.size(); i++){
            if((Integer)sumList.get(i) > max){
                max = (Integer)sumList.get(i);
            }
        }
        System.out.println(max.toString());

//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println("");
//        }
    }



}
class Pos {
    int i, j;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pos)) return false;

        Pos pos = (Pos) o;

        if (i != pos.i) return false;
        return j == pos.j;

    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}