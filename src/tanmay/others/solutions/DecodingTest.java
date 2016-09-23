package tanmay.others.solutions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * Created by tanmaymehra on 7/8/16.
 */
public class DecodingTest {

    public static void main(String[] args) throws IOException {
        String tmp = "itestDatabase%E4%E1%C1%E9%C9";

        String original = "itestDatabaseäčáÁéÉ";

        System.out.println(System.getProperty("file.encoding"));

        FileInputStream fis = null;
        InputStreamReader isr =null;
        StringBuilder sb = new StringBuilder();
        char c;
        int i;

        try {
            // new input stream reader is created
            fis = new FileInputStream("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/others/solutions/test.txt");
            isr = new InputStreamReader(fis);
            System.out.println(isr.getEncoding());
            // read till the end of the file
            while((i=isr.read())!=-1)
            {
                // int to character
                c=(char)i;

                // print char
                sb.append(c);
            }
        } catch (Exception e) {

            // print error
            e.printStackTrace();
        } finally {

            // closes the stream and releases resources associated
            if(fis!=null)
                fis.close();
            if(isr!=null)
                isr.close();
        }


        System.out.println(sb.toString());
        String s1 = URLDecoder.decode(tmp, "UTF-8");

        String s2 = URLDecoder.decode(tmp, "ISO-8859-1");

        System.out.println(s1);

        System.out.println(s2);
    }


}
