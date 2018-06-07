package tanmay.practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) {
        String url = "https://localhost:9090/sas/dss/dsds";
        int firstSlashIndex = url.indexOf('/');
        String sub = url.substring(firstSlashIndex + 2);
        System.out.println(sub.indexOf('/'));
        String queryParam = sub.substring(sub.indexOf('/'));
        System.out.println(queryParam);
    }
}
