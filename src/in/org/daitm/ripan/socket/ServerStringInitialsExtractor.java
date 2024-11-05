package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringInitialsExtractor {

    static String extractedName(String fullName){
        StringBuilder initials = new StringBuilder();
        String []parts = fullName.split(" ");
        for(String part : parts){
            initials.append(part.charAt(0));
        }
        return initials.toString();
    }
    public static void main(String[] args) {

        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server is waiting..");
            Socket socket = serverSocket.accept();
            System.out.println("Client is connected..");

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fullName = clientInput.readLine();

            String extractedName = extractedName(fullName);
            System.out.println("Name Send by Clients : "+fullName);
            System.out.println("Initials form is : "+extractedName);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(extractedName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
