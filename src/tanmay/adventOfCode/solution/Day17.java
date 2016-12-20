package tanmay.adventOfCode.solution;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by tanmaymehra on 12/17/16.
 */
public class Day17 {

    public static void main(String[] args) {

        String s = "ihgpwlah";
        int[][] arr = new int[4][4];
        int i = 0, j = 0;

        for(int k=0 ;k <4;k++){
            for(int l=0;l<4;l++){
                if(k==3 && l==3){
                    arr[k][l] =3;
                }else{
                    arr[k][l] =0;
                }
            }
        }

        shortestPath(arr,s);

//        List<Character> result = new ArrayList<>();
//        Stack<String> direction = new Stack<>();
//
//        while (i != 3 || j != 3) {
//
//            String md = getMD5Hash(s).toLowerCase().substring(0, 4);
//            int up = charIsValid(md.charAt(0)) ? 1 : 0;
//            int down = charIsValid(md.charAt(1)) ? 1 : 0;
//            int left = charIsValid(md.charAt(2)) ? 1 : 0;
//            int right = charIsValid(md.charAt(3)) ? 1 : 0;
//
//
//            if (down == 1 && i + down <= 3 && !direction.peek().equals("D")) {
//                s = s + "D";
//                i++;
//                if(!direction.isEmpty()){
//                    direction.pop();
//                }
//            } else if (right == 1 && j + right <= 3 && !direction.peek().equals("R")) {
//                s = s + "R";
//                j++;
//                if(!direction.isEmpty()){
//                    direction.pop();
//                }
//            } else if (left == 1 && j - left >= 0 && !direction.peek().equals("L")) {
//                s = s + "L";
//                j--;
//                if(!direction.isEmpty()){
//                    direction.pop();
//                }
//            } else if (up == 1 && i - up >= 0 && !direction.peek().equals("U")) {
//                s = s + "U";
//                i--;
//                if(!direction.isEmpty()){
//                    direction.pop();
//                }
//            } else{
//                s= s.substring(0,s.length());
//                direction.push(s.substring(s.length()-1,s.length()));
//            }
//        }
//
//        System.out.println(s);

//        System.out.println(getPath(s,i,j));

    }

    //DDUDRLRRUDRD

    private static String getPath(String st, int i, int j) {

        if (i == 3 && j == 3) {
            System.out.println("P::"+st);
            return st;

        }

        String md = getMD5Hash(st).toLowerCase().substring(0, 4);
        int up = charIsValid(md.charAt(0)) ? 1 : 0;
        int down = charIsValid(md.charAt(1)) ? 1 : 0;
        int left = charIsValid(md.charAt(2)) ? 1 : 0;
        int right = charIsValid(md.charAt(3)) ? 1 : 0;


        if (down == 1 && i + down <= 3) {
            st = st + "D";
            st = getPath(st,++i,j);
        }
        if (right == 1 && j + right <= 3) {
            st = st + "R";
            st = getPath(st,i,++j);
        }
        if (left == 1 && j - left >= 0) {
            st = st + "L";
            st = getPath(st,i,--j);
        }
        if (up == 1 && i - up >= 0) {
            st = st + "U";
            st = getPath(st,--i,j);
        }
        if(up ==0 && down==0 && left==0 && right==0){
            return st.substring(0,st.length()-1);
        }
        return st;
    }

    private static boolean charIsValid(char c) {

        if (c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') {
            return true;
        }
        return false;
    }

    private static String getMD5Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }


    private static void shortestPath(int[][] matrix, String st) {
        int N = matrix.length;
        // initial
        PathStep step = new PathStep(1, 1, null);
        LinkedList<PathStep> queue = new LinkedList<PathStep>();
        queue.add(step);
        // using set to check if already traversed
        HashSet<Integer> set = new HashSet<Integer>();
        boolean findDest = false;
        while (!queue.isEmpty() && !findDest) {
            LinkedList<PathStep> tmpQueue = new LinkedList<PathStep>();
            while (!queue.isEmpty()) {
                step = queue.remove();
                int i = step.i, j = step.j, id;
                if (matrix[i][j] == 3) {    // find dest
                    findDest = true;
                    break;
                }
                PathStep next;
                String md = getMD5Hash(st).toLowerCase().substring(0, 4);
                int up = charIsValid(md.charAt(0)) ? 1 : 0;
                int down = charIsValid(md.charAt(1)) ? 1 : 0;
                int left = charIsValid(md.charAt(2)) ? 1 : 0;
                int right = charIsValid(md.charAt(3)) ? 1 : 0;
                // move left
                if (j > 0 && left == 1 && j - left >= 0) {
                    id = N * i + (j - 1);
                    st = st + "L";
                    if (!set.contains(id)) {
                        set.add(id);
                        next = new PathStep(i, j - 1, step);
                        tmpQueue.add(next);
                    }
                }
                // move right
                if (j < N - 1 && right == 1 && j + right <= 3) {
                    id = N * i + (j + 1);
                    st = st + "R";
                    if (!set.contains(id)) {
                        set.add(id);
                        next = new PathStep(i, j + 1, step);
                        tmpQueue.add(next);
                    }
                }
                // move up
                if (i > 0 && up == 1 && i - up >= 0) {
                    id = N * (i - 1) + j;
                    st = st + "U";
                    if (!set.contains(id)) {
                        set.add(id);
                        next = new PathStep(i - 1, j, step);
                        tmpQueue.add(next);
                    }
                }
                // move down
                if (i < N - 1 && down == 1 && i + down <= 3) {
                    id = N * (i + 1) + j;
                    st = st + "D";
                    if (!set.contains(id)) {
                        set.add(id);
                        next = new PathStep(i + 1, j, step);
                        tmpQueue.add(next);
                    }
                }
            }
            queue = tmpQueue;
        }
        if (findDest) {
            // build path
            ArrayList<PathStep> path = new ArrayList<PathStep>();
            while (step != null) {
                path.add(step);
                step = step.prev;
            }
            Collections.reverse(path);
            // print path
            int l =0;
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    System.out.println(path.get(i));
                } else {
                    l++;
                    System.out.print(path.get(i) + " -> ");
                }
            }
            System.out.println("l  "+ l);
        }
    }

}
