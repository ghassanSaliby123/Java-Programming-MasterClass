
package com.ghassan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Main {

    //UDP Server
    //- Instead of using ServerSocket like the TCP we use DatagramSocket with UDP to establish the
    //Port that will be used through the communication
    //- We mainly create a packet that holds the received message from the client
    //we do that through DatagramPacket, and we assign a char buffer to it
    //- Then we call the socket.receive() method to receive data
    public static void main(String[] args) {
        try {
            //Establish a socket for connection
            DatagramSocket socket = new DatagramSocket(5001);

            while (true) {
                //Create a packet that holds the received message
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                //receive the data from the socket and fill data to the packet
                socket.receive(packet);
                System.out.println("Text received is :" + new String(buffer,0,packet.getLength()));

                //Sending back the same packet to the client
                String returnString = "echo: "+ new String(buffer,0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2,buffer2.length,address,port);
                socket.send(packet);
            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
