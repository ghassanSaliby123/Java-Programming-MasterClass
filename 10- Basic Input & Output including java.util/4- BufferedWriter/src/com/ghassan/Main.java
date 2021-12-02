package com.ghassan;

import java.util.Map;
import java.util.Scanner;

public class Main {
    //This example is described in the Description text file
    //It tends to use the Adventure Game example from the Collection examples to implement IO
    //We use FileReader(extends the InputStreamReader) to read the directions (stream of characters)
    //from a directions text file.
    //We wrap the FileReader object with a BuffetReader to increase the read characters ability
    //since the Buffer capacity is 8K. Then we warp the BufferReader with a Scanner Object
    //When closing the scanner stream, the FileReader stream will close automatically
    //because the Scanner implements the closeable interface which makes
    //sure that the stream is closed after writing or reading
    //We use the BufferedWriter to wrap the FileWriter to read more data at once instead of
    // reading a character by character
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
