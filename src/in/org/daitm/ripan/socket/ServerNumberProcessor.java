package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
*   1. Server accept two numbers send by client
*   2. process it, print it
*   3. result is send to the client
 */
public class ServerNumberProcessor {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server is Waiting..");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected...");

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int num1 = Integer.parseInt(clientInput.readLine());
            int num2 = Integer.parseInt(clientInput.readLine());

            int sum = num1 + num2;

            System.out.println("Number send by Client are :"+num1+" and "+num2);
            System.out.println("Sum is :"+sum);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(sum);

            socket.close();
            serverSocket.close();
            clientInput.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
