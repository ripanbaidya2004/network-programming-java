package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Principal;

public class ClientStringSender {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 9999);
            System.out.println("server is connected..");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter your name : ");
            String fullName = input.readLine();
            out.println(fullName);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String extractedName = in.readLine();
            System.out.println("Name received from server : " + extractedName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
