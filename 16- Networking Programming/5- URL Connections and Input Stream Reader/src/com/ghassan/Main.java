package com.ghassan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    //- When calling the url.openStream method it will establish a socket and a connection
    //This method perform 2 methods : the url.openConnection which returns an url connection
    //Then we can get an inputStream for the connection
    //- Another way is to use the url.openConnection that return a URLConnection
    //then we call the urlConnection.connect() method that allows to just read data by default
    //If we want to change it to writing as well we call urlConnection.setDoOutput(true)
    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            //The first way to fetch data from a webpage
            //Get an url connection and wrap it with inputStreamReader through url.openStream
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while (line!= null){
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

            System.out.println("===========================================");
            //The second way to fetch data from a webpage
            //Get an URLConnection through url.openConnection
            //Then use the connect method
            URLConnection urlConnection = url.openConnection();
            //set the connection to write not just to read
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream2 = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String line2 = "";
            while (line2!= null){
                line2 = inputStream.readLine();
                System.out.println(line2);
            }
            inputStream2.close();

        }catch (IOException e){
            System.out.println("IOException :" + e.getMessage());
        }
    }
}
