package com.ghassan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //This example is described in the Description text file
    //It tends to use the Adventure Game example from the Collection examples to implement IO
    //We use FileWriter(extends the OutputStreamWriter) to write the locations (stream of characters)
    //into location text file
    //Implementing try with resource which is introduced with Java 7 with the resources that implement
    // the Closeable interface which make sure that the stream is closed after writing or reading

    private static Locations locations= new Locations();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            }else {
                System.out.println("This is a wrong direction");

            }

        }
    }
}
