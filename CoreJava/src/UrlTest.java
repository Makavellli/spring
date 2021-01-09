import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws MalformedURLException {

        URL url2 = new URL("www.baidu.com");
        System.out.println(url2);

        URL url = new URL("www.123.com");
        System.out.println(url);
    }
}
