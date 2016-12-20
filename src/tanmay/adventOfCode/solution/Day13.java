package tanmay.adventOfCode.solution;

/**
 * Created by tanmaymehra on 12/13/16.
 */
public class Day13 {


    public static void main(String[] args) {

        int x = 80, y = 80;
        int[][] arr = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = getValue(j, i);
            }
        }
//        arr[39][31]= 3;

        ShortestPathInMaze.shortestPath(arr);

//        for (int i = 0; i < x; i++) {
//            System.out.print("{ ");
//            for (int j = 0; j < y; j++) {
//                System.out.print(arr[i][j]);
//                if(j !=y-1){
//                    System.out.print(", ");
//            }
//            }
//            System.out.println(" },");
//        }


    }

    private static int getValue(int x, int y) {

        int k = (x * x + 3 * x + 2 * x * y + y + y * y) + 1352;

        String binString = Integer.toBinaryString(k);
        int n = 0;
        for (int i = 0; i < binString.length(); i++) {
            if (binString.charAt(i) == '1') {
                n++;
            }
        }
        if (n % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
