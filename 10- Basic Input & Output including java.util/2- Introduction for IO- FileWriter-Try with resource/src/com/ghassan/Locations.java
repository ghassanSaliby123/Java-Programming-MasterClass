package com.ghassan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) throws IOException {
        //try with resources
        try (FileWriter locationFile = new FileWriter("locations.txt");
        FileWriter directionFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locationFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                //writing the exits into direction txt
                for (String direction : location.getExits().keySet()) {
                    directionFile.write(location.getLocationID() + ", " + direction + ", "
                    + location.getExits().get(direction)+ "\n");
                }
            }

//        FileWriter localFile = null;
//        try {
//            localFile = new FileWriter("locations.txt");
//            for (Location value : locations.values()) {
//                localFile.write(value.getLocationID()  + ", "+value.getDescription()+"\n");
//            }
//        }
//       finally {
//            System.out.println("Close the writing stream..");
//                localFile.close();
//
//        }


        }
    }


    static {
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
    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsKey(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
