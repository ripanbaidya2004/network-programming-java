package in.org.daitm.ripan.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFileReceiver {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket socket = serverSocket.accept();
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            // Read the file name
            String fileName = objectInputStream.readUTF();
            try (FileOutputStream fileOutputStream = new FileOutputStream("received_" + fileName)) {

                // Receive file in chunks
                byte[] buffer = new byte[4096]; // 4 KB buffer
                int bytesRead;
                while ((bytesRead = objectInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("File received and saved as received_" + fileName);

            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
