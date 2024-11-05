package in.org.daitm.ripan.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientImageSender {


    private static final String IMAGE_URL = "C:\\images\\github_photo.jpg";

    public static void main(String [] s) throws Exception {

        try (Socket socket = new Socket("localhost", 9999);
             FileInputStream fileInputStream = new FileInputStream(new File(IMAGE_URL));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            objectOutputStream.writeObject(buffer);
            System.out.println("Image sent successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
