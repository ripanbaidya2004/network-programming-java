package in.org.daitm.ripan.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server is waiting for clinet..");
        Socket socket = serverSocket.accept();
        System.out.println("Clinet connected.. ");

        while(true) {
            System.out.print("Server(enter message): ");
            BufferedReader serverSendMessageToClient = new BufferedReader(new InputStreamReader(System.in));
            String sendMessage = serverSendMessageToClient.readLine();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(sendMessage);

            // server receive message
            BufferedReader serverReceiveMessageFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String receiveMessage = serverReceiveMessageFromClient.readLine();

            System.out.println("Client: " + receiveMessage);
        }
    }
}
