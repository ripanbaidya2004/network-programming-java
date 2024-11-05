package in.org.daitm.ripan.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLMethods {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://www.daitm.org.in/wp-content/uploads/2022/06/BCA.pdf");
            System.out.println(u.toString());
            System.out.println("Protocol : "+u.getProtocol());
            System.out.println("Host name : "+u.getHost());
            System.out.println("Port : "+u.getPort());
            System.out.println("Authority :"+u.getAuthority());
            System.out.println("Default port : "+u.getDefaultPort());
            System.out.println("File name : "+u.getFile());
            System.out.println("User info :"+u.getUserInfo());
            System.out.println("Query : "+u.getQuery());
            System.out.println("Ref "+u.getRef());
            System.out.println("Absolute : "+u.toExternalForm());
            System.out.println("Path : "+u.getPath());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
