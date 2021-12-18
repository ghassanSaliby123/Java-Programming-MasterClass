package com.ghassan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {


    //After we set up the connection we can call getHeaderFields to get the headers info
    //We can use HttUrlConnection to set up connection for http communication
    //We set the request method(GET, POST, PUT , DELETE)
    //Then we can set the request properties
    //Here we didn't use the httpConnction.connect() method because the methods getResponseCode
    //and the getInoutStream are implicitly call the connect() method
    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            //The second way to fetch data from a webpage
            //Get an URLConnection through url.openConnection
            //Then use the connect method
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            //Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response code : " + responseCode);
            //Set the time-out for reading
            connection.setReadTimeout(30000);
            if (responseCode != 200){
                System.out.println("Error reading web page");
                connection.getResponseMessage();
                return;
            }
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = inputStream.readLine()) != null){
                System.out.println(line);
            }

            //set the connection to write not just to read
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//            //Get the headers info
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("Key = " + key);
//                for (String s : value) {
//                    System.out.println("value = " + value);
//                }
//            }
//            String line = "";
//            while (line!= null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

        }catch (IOException e){
            System.out.println("IOException :" + e.getMessage());
        }
    }
}
