package com.timbuchalka;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //This example is described in the Description text file
    //It tends to use the Adventure Game example from the Collection examples to implement IO
    //So far with character streams and Byte streams we read the data sequentially from the file
    //start from the beginning of the file to the end
    //The Random Access File allows us to jump inside the file to read the required data instead of
    // reading the data sequentially to reach the required data.
    //That saves memory and the number of accessing the file
    //we use the term offset which is a byte location in a file, that helps to point to a specific point
    // in a file

    private static Locations locations = new Locations();

    public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 64;
        while(true) {
            System.out.println(locations.get(loc).getDescription());

            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
