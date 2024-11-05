package in.org.daitm.ripan.url;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckSameURLOrNot {
    public static void main(String[] args) throws MalformedURLException {

        URL ww = new URL ("http://www.ibiblio.org/");
        URL ib = new URL("http://ibiblio.org/");

        if(ww.equals(ib)){
            System.out.println("Both are same");
        }else{
            System.out.println("are not same");
        }
    }
}
