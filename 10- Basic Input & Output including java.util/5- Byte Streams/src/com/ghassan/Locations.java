package com.ghassan;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        //Write data into locations text file
       try (DataOutputStream locFile = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("locations.dat")))){
           for (Location location : locations.values()) {
               locFile.writeInt(location.getLocationID());
               locFile.writeUTF(location.getDescription());
               System.out.println("Writing location " + location.getLocationID() + " : "+ location.getDescription());
               System.out.println("Writing "+ (location.getExits().size() -1)+ " exits." );
               locFile.writeInt(location.getExits().size() -1);
               for (String direction : location.getExits().keySet()) {
                   if (!direction.equalsIgnoreCase("Q")){
                       System.out.println(direction+","+location.getExits().get(direction));
                       locFile.writeUTF(direction);
                       locFile.writeInt(location.getExits().get(direction));
                   }
               }
           }
       }


    }
    static {
        //Read the locations
           try(DataInputStream locFile = new DataInputStream(new
                   BufferedInputStream(new FileInputStream("locations.txt")))){
               boolean eof = false;
               while (!eof){
                   try {
                       Map<String, Integer> exits = new LinkedHashMap<>();
                       int locID = locFile.readInt();
                       String description = locFile.readUTF();
                       int numExits = locFile.readInt();
                       System.out.println("Read location "+ locID + " : "+description);
                       System.out.println("Found "+ numExits + " exits.");
                       for (int i = 0; i < numExits; i++) {
                           String direction = locFile.readUTF();
                           int destination = locFile.readInt();
                           exits.put(direction, destination);
                           System.out.println("\t" + direction +","+destination);
                       }
                       locations.put(locID,new Location(locID,description,exits));
                   }catch (EOFException e){
                       eof = true;
                   }
                   }

           }catch (IOException e){
               System.out.println("IOException");
           }
//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))){
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()){
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Reade loc "+ loc + ": "+ description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc,new Location(loc, description, tempExit));
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()){
//                String input = scanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data [1];
//                int destination = Integer.parseInt(data [2] );
//                System.out.println(loc + ": "+ direction +": "+ destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }

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
