package in.org.daitm.ripan.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientFileSender {
    private static final String FILE_PATH = "filename.txt"; // Replace with your file's path

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 9999);
             FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {

            // Send file name and size to the server first
            objectOutputStream.writeUTF(new File(FILE_PATH).getName());
            objectOutputStream.flush();

            // Send file in chunks
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                objectOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
