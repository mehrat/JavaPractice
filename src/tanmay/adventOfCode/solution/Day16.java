package tanmay.adventOfCode.solution;

/**
 * Created by tanmaymehra on 12/16/16.
 */
public class Day16 {

    public static void main(String[] args) {

        String s = "01111001100111011";


        while (s.length() < 35651584) {
            StringBuilder sb = new StringBuilder(s);
            sb.append("0");

            for (int i = s.length()-1; i >=0; i--) {
                if (s.charAt(i) == '1') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            s = sb.toString();
        }

//10000011110010000111
        String orig = s.substring(0, 35651584);
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= orig.length()-2; i = i + 2) {
                if (orig.charAt(i) == orig.charAt(i + 1)) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            orig = sb.toString();
            if (orig.length() % 2 != 0) {
                break;
            }
        }
        System.out.println(orig);

    }

}
