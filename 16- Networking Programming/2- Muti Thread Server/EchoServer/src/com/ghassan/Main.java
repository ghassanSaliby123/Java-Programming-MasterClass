package com.ghassan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    //This the Server application
    //Change the server to handle requests from different clients through threads
    public static void main(String[] args) {

        //Create a socket for the server on port 5000
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            while (true){
                //create a socket for each client and receive its message and response
                //This implementation is in a class Echoer to create a new thread for each client

                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }
        }catch (IOException e){
            System.out.println("Server exception :"+ e.getMessage());
        }
    }
}
