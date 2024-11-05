package in.org.daitm.ripan.inetadd;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressSample {
    public static void main(String[] args) throws UnknownHostException {
        // getLocalHost
        InetAddress inetAddress = InetAddress.getLocalHost();

        // getByName(String hostname), getAllByName(String hostname)
        InetAddress []initAddress2 = InetAddress.getAllByName("www.google.com");
        for(InetAddress i : initAddress2){
            System.out.println(i);
        }

        // getByAddress(byte[] arr)
        byte[] arr = new byte[]{1, 2, 3, 4};
        InetAddress initAddress = InetAddress.getByAddress(arr);
        InetAddress inetAddress1 = InetAddress.getByAddress("localhost", arr);

        System.out.println(initAddress.getHostName());
        System.out.println(inetAddress1.getHostName());
    }
}
