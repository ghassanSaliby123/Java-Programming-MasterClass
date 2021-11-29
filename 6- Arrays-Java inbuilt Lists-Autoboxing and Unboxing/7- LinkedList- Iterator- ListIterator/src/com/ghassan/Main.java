package com.ghassan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    //This example illustrates the LinkedList with using iterator and ListIterator interface
    //The general idea of a linkedlist is that each element points to the next one
    //it helps us when we want to add, insert or remove an object just by change the pointer value behind the scene
    //Iterator function can be used instead of for loop to iterate over the objects in the list
    //ListIterator is an interface which provides functions that help us to iterate the list in both sides
    //next and previous. It is more useful when we want to insert, remove, add objects after a specific type
    //of validation.
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();
        places.add("Brussels");
        places.add("Antwerp");
        places.add("Gent");
        places.add("Brouge");
        places.add("Saint Nicholas");
        places.add("Louven");
        places.add("Namur");
        places.add("Liege");

        printPlaces(places);

        //Try to add another object to list in a specific place
        places.add(1,"Uppsala");
        printPlaces(places);

        //Try to remove an object from the list
        places.remove(4);
        printPlaces(places);
        //--------------------------------------------------------------------
        //Now let us try to add the elements in the linkedList in order
        LinkedList<String> orderedPlaces = new LinkedList<>();
        addInOrder( orderedPlaces,"Brussels");
        addInOrder( orderedPlaces,"Antwerp");
        addInOrder( orderedPlaces,"Gent");
        addInOrder( orderedPlaces,"Broug");
        addInOrder( orderedPlaces,"Saint Nicholas");
        addInOrder( orderedPlaces,"Louven");
        addInOrder( orderedPlaces,"Namur");
        printPlaces(orderedPlaces);

    }

    //Printing the LinkedList elements by using iterator
    public static void printPlaces(LinkedList<String> places){
        //this iterates over the Linkedlist in one direction
        Iterator<String> iterator = places.iterator();
        while (iterator.hasNext()){
            System.out.println("The current city is : " + iterator.next());
        }
        System.out.println("---------------------------------");
    }

    //Add a new element in order using ListIterator and its functions
    public static boolean addInOrder(LinkedList<String> orderedPlaces,String newCity){
        ListIterator<String> listIterator = orderedPlaces.listIterator();
        while (listIterator.hasNext()){
            int compare = listIterator.next().compareTo(newCity);
            if (compare > 0 ){
                //Since we used next which give the current value and point to the next value
                //we should point to the previous value where we have to add the newCity
                listIterator.previous();
                listIterator.add(newCity);
                return true;
            }
        }
        listIterator.add(newCity);
        return true;

    }

}
