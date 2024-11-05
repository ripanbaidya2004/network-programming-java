package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClient() {
        try {
            socket = new Socket("localhost", 9999);
            System.out.println("Connected to server");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(this::clientReceiveMessage).start();
            new Thread(this::clientSendMessage).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clientSendMessage() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String mssgSend;
            while ((mssgSend = input.readLine()) != null) {
                if (mssgSend.equalsIgnoreCase("exit")) {
                    out.println("Client: " + mssgSend);
                    closeResources();
                    break;
                }
                out.println("Client: " + mssgSend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clientReceiveMessage() {
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
            if (out != null) out.close();
            if (in != null) in.close();
            System.out.println("Resources Closed...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
