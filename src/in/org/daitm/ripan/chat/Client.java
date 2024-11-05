package in.org.daitm.ripan.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Connected to the server..");

        while(true) {

            // message receive
            BufferedReader clientReceiveMessageFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String receivedMessage = clientReceiveMessageFromServer.readLine();
            System.out.println("Server: " + receivedMessage);

            // message send
            System.out.print("Clinet(enter message): ");
            BufferedReader clientSendMessageToServer = new BufferedReader(new InputStreamReader(System.in));
            String sendMessage = clientSendMessageToServer.readLine();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(sendMessage);
        }
    }
}
