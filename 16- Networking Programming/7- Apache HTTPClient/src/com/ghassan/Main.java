package com.ghassan;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

public class Main {

    //Through this example we use the Apache HTTPClient instead of HTTPURConnection
    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-Agent", "Chrome");

        try {
            CloseableHttpResponse response = httpClient.execute(request);
            System.out.println("Response code = "+ response.getCode());

             BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = inputStream.readLine()) != null){
                System.out.println(line);
            }
            inputStream.close();
        }catch (IOException e){
            System.out.println("IOException : " +e.getMessage());
        }

    }
}
