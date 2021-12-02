package com.ghassan;

import java.util.Map;
import java.util.Scanner;

public class Main {
    //This example is described in the Description text file
    //It tends to use the Adventure Game example from the Collection examples to implement IO
    //We use DataOutputStream to write the locations and the
    // directions (stream of Bytes) into a locations dat file
    //DataOutputStream wraps BufferedOutputStream which also wraps FileOutputStream (extends OutputStream)
    //DataOutputStream has various functions to write data such as writeInt for integers
    // and writeUTF for string
    //We use DataInputStream to read from a file
    //Those classes works with primitive types and string
    //When we want to read and write Objects we need to implement the serialization
    //While reading from a file we should catch the end of file exception EOF, we should stop reading when
    //we reach the end of the file


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
