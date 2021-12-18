package com.ghassan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    //This is the Client
    //- Since all clients connect to the server through the serverSocket with port number 5000,
    //each client should have its own socket to communicate with the server so:
    //- We define a socket from the Socket class, and we define the address of the server and the port
    // number
    //- Then we use PrintWrite to write the message to the server. We use PrintWriter as a wrap for
    // the socket.getOutputStream, and we activate the auto flush to send  response automatically
    // The method blocks until a connection is made
    //- Then we create a bufferedReader to fetch the response from the server
    //- When the connection is made through the client, the server reads the client input
    //through socket.getInputStream
    //- Then the server process the message and give a response as an output
    //- We use PrintWrite as a wrap for the socket.getOutputStream, and we activate the auto flush to send
    //response automatically
    //- In this example the server just read to the client and sends back the same message
    // until it reads exit then it terminates
    public static void main(String[] args) {

        //Create a socket on the clint side to communicate with the server on address localhost and port 5000
        try(Socket socket = new Socket("localhost",5000)){
            //Create a printWrite to hold the message that the client wants to send to server
            PrintWriter clientMessage = new PrintWriter(socket.getOutputStream(),true);
            //Create a bufferedReader to fetch the response from the server
            BufferedReader serverMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //This to get the user input and set the clientMessage
            Scanner scanner = new Scanner(System.in);
            String requestString;
            String response;

            do {
                System.out.println("Enter string to be echoed:");
                requestString = scanner.nextLine();
                clientMessage.println(requestString);
                if (!requestString.equals("exit")){
                    response = serverMessage.readLine();
                    System.out.println(response);
                }
            }while (!requestString.equals("exit"));

        }catch (IOException e){
            System.out.println("Client error : "+ e.getMessage());
        }
    }
}
