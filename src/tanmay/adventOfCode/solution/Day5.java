package tanmay.adventOfCode.solution;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tanmaymehra on 12/5/16.
 */
public class Day5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String stb = "abbhdwsy";
        int a = 0;
        int count =0;
        while (true) {
            String st = stb + a;
            String has = getMd(st);
            if(has.substring(0,5).equals("00000")){
                System.out.println(has.charAt(5) + "  "+ has.charAt(6));
                count++;
                if(count==30){
                    break;
                }
            }
            a++;
        }


    }

    static String getMd(String input) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(input.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
    return hashtext;
    }
}
