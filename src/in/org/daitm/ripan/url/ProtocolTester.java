package in.org.daitm.ripan.url;

import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTester {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("www.meta.com");
        System.out.println("Protocol is :"+url.getProtocol());
    }
}
