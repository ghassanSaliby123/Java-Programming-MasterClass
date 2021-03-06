package com.ghassan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //This example is described in the Description text file
    //It tends to make the Adventure Game example immutable which means that the classes cant
    //be changed when they are created by:
    //not providing setter methods
    //make the fields private and final
    //not allow the subclasses to override methods by declaring the class as final

    private  static Map<Integer,Location> locations = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit =new HashMap<>();
        locations.put(0, new Location(0, "You are in front of a computer.",tempExit));
        tempExit =new HashMap<>();
        tempExit.put("W",2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are at the end of the road.",tempExit));
        tempExit =new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill.",tempExit));

        tempExit =new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building.",tempExit));
        tempExit =new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream.",tempExit));
        tempExit =new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 3);
        locations.put(5, new Location(5, "You are in the forest.",tempExit));
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
