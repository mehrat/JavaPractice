package tanmay.adventOfCode.solution;

/**
 * Created by tanmaymehra on 12/18/16.
 */
public class Day18 {

    public static void main(String[] args) {

        String s = "^.^^^..^^...^.^..^^^^^.....^...^^^..^^^^.^^.^^^^^^^^.^^.^^^^...^^...^^^^.^.^..^^..^..^.^^.^.^.......";

        int col = s.length();
        int row = 400000;

        char[][] arr = new char[row][col];


        for (int i = 0; i < col; i++) {
            arr[0][i] = s.charAt(i);
        }


        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char left, right, center;
                center = arr[i - 1][j];
                if (j == 0) {
                    left = '.';
                } else {
                    left = arr[i - 1][j - 1];
                }

                if (j == col-1) {
                    right = '.';
                } else {
                    right = arr[i - 1][j + 1];
                }
                if (isTrap(left, center, right)) {
                    arr[i][j] = '^';
                } else {
                    arr[i][j] = '.';
                }
            }
        }
        int n = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == '.') {
                    n++;
                }
            }
        }

        System.out.println(n);

    }

    private static boolean isTrap(char left, char center, char right) {

        if (left == '^' && center == '^' && right != '^') {
            return true;
        }
        if (right == '^' && center == '^' && left != '^') {
            return true;
        }
        if (left == '^' && center != '^' && right != '^') {
            return true;
        }
        if (right == '^' && center != '^' && left != '^') {
            return true;
        }
        return false;
    }
}
