package com.ghassan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    //This the Server application
    //- First we create a ServerSocket on a port that is allocated to connect to the clients
    //We define the port number as 5000
    //- Since all clients connect to the server through the serverSocket with port number 5000,
    //each client should have its own socket to communicate with the server
    //- We define a socket from the ServerSocket through accept() method to communicate with a client
    //- The accept method listens for a connection to be made to this socket and accepts it.
    // The method blocks until a connection is made
    //- When the connection is made through the client, the server reads the client input
    //through socket.getInputStream
    //- Then the server process the message and give a response as an output
    //- We use PrintWrite as a wrap for the socket.getOutputStream, and we activate the auto flush to send
    //response automatically
    //- In this example the server just read to the client and sends back the same message
    // until it reads exit then it terminates
    public static void main(String[] args) {

        //Create a socket for the server on port 5000
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            //create a socket for the client to be blocked until the connection is established
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.....");
            //Read client message and treat as server input
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           //Write the server output to the client
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(),true);
            //What the server does(read till finds exit)
            while (true){
                String clientMessage = serverInput.readLine();
                if (clientMessage.equals("exit")){
                    break;
                }
                //send the same message back to client
                serverOutput.println("Message from the server: "+ clientMessage  );
            }

        }catch (IOException e){
            System.out.println("Server exception :"+ e.getMessage());
        }
    }
}
