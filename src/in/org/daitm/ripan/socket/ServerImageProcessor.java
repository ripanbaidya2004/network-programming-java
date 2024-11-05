package in.org.daitm.ripan.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImageProcessor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket socket = serverSocket.accept();
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream("receiveImage.jpg")) { // name of the image, we want to save

            byte[] buffer = (byte[]) objectInputStream.readObject();
            fileOutputStream.write(buffer);

            System.out.println("Image received and saved as pic2.jpg");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
