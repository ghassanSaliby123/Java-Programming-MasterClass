package com.ghassan;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    //UDP Client
    //- First we call InetAddress to get the localHost address
    //- Then we create a socket through DatagramSocket in order to send data though it
    //- Then we create a packet through DatagramPacket to fill it with data
    //this packet also holds info about the server port and IP
    //That's the opposite of TCP since the address is known after we establish the connection
    //but with UDP we have to add this info to each packet
    //- Then we call the socket.send() to send data to the server

    public static void main(String[] args) {
        try {
            //Get the local host address
            InetAddress address = InetAddress.getLocalHost();//getByName()
            //Create a socket to send data
            DatagramSocket datagramSocket = new DatagramSocket();
            //Accept user input
            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed: ");
                //Read user input and turn it to Bytes
                echoString = scanner.nextLine();
                byte[] buffer = echoString.getBytes();
                //Create a packet, fill it with data in the buffer and add the server port and address
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,address,5001);
                datagramSocket.send(packet);

                //Receive the response from the server
                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received from server: " + new String(buffer2, 0,
                        packet.getLength()));

            } while (!echoString.equals("exist"));

        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
