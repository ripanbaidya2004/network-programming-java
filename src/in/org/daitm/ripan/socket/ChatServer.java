package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Server is Waiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client Connected...");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(this::serverReceiveMessage).start();
            new Thread(this::serverSendMessage).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverSendMessage() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String mssgSend;
            while ((mssgSend = input.readLine()) != null) {
                if (mssgSend.equalsIgnoreCase("exit")) {
                    out.println("Server: " + mssgSend);
                    closeResources();
                    break;
                }
                out.println("Server: " + mssgSend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverReceiveMessage() {
        try {
            String mssgReceive;
            while ((mssgReceive = in.readLine()) != null) {
                System.out.println(mssgReceive);
                if (mssgReceive.equalsIgnoreCase("exit")) {
                    closeResources();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeResources() {
        try {
            if(socket != null) socket.close();
            if(serverSocket != null) serverSocket.close();
            if (out != null) out.close();
            if (in != null) in.close();
            System.out.println("Resources Closed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
