import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9191);
        System.out.println("Server is waiting..");
        Socket socket = serverSocket.accept();
        System.out.println("Client is connected..");


        // send message
        BufferedReader serverSendMessageToClient = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server: ");
        String message = serverSendMessageToClient.readLine();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);

        // receive message
        BufferedReader serverReceiveMessageFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receiveMessage = serverReceiveMessageFromClient.readLine();
        System.out.println("Client: " + receiveMessage);

    }
}