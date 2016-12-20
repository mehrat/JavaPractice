package tanmay.adventOfCode.solution;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;


/**
 * Created by tanmaymehra on 12/14/16.
 */
public class Day14 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String salt = "zpqevtbw";

        int n = 0;
        int k = 0;

        while (k < 64) {
            char l = ' ';
            l = tripleMd(salt + n);
            if (l != ' ') {
                int t = n + 1;
                while (t != n + 1000) {
                    if (searchInNextThousand(salt + t, l)) {
                        k++;
                        break;
                    }
                    t++;
                }
            }
            n++;
        }
        System.out.println(n - 1);

    }

    private static boolean searchInNextThousand(String s, char l) throws NoSuchAlgorithmException {

        String md = getMD5Hash(s.toLowerCase()).toLowerCase();
        int j = 0;
        while (j != 2016) {
            md = getMD5Hash(md.toLowerCase()).toLowerCase();
            j++;
        }
        int i = 0;
        while (i != md.length() - 4) {
            if (md.charAt(i) == l && md.charAt(i) == md.charAt(i + 1) && md.charAt(i) == md.charAt(i + 2) && md.charAt(i) == md.charAt(i + 3) && md.charAt(i) == md.charAt(i + 4)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private static char tripleMd(String s) throws NoSuchAlgorithmException {
        System.out.println(s);

        String md = getMD5Hash(s.toLowerCase()).toLowerCase();
        int j = 0;
        while (j != 2016) {
            md = getMD5Hash(md.toLowerCase()).toLowerCase();
            j++;
        }
        int i = 0;
        while (i != md.length() - 2) {
            if ( md.charAt(i) == md.charAt(i + 1) && md.charAt(i) == md.charAt(i + 2)) {
                return md.charAt(i);
            }
            i++;
        }
        return ' ';
    }

    static String getMd(String input) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(input.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
//        while (hashtext.length() < 32) {
//            hashtext = "0" + hashtext;
//        }
        return hashtext;
    }

    private static String getMD5Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }


}
