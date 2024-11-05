package in.org.daitm.ripan.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
*   1. send two number to the server
*   2. accept the sum and print it
 */
public class ClientNumberSender {
    public static void main(String[] args) {

        try{
            Socket socket = new Socket("localhost", 9999);
            System.out.println("server is connected..");

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Enter the first number :");
            int num1 = Integer.parseInt(input.readLine());
            out.println(num1);

            System.out.println("Enter the second number :");
            int num2 = Integer.parseInt(input.readLine());
            out.println(num2);


            BufferedReader res = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("The sum is :"+Integer.parseInt(res.readLine()));

            socket.close();
            input.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
