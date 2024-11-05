import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost", 9191);
        System.out.println("Server is connected..");

        // receive message
        BufferedReader clientReceiveMessageFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receivedMessage = clientReceiveMessageFromServer.readLine();
        System.out.println("Server: " + receivedMessage);

        // send message
        BufferedReader clientSendMessageToServer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client: ");
        String message = clientSendMessageToServer.readLine();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);

        socket.close();
    }
}