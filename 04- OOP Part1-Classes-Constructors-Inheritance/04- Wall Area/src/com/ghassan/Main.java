package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    //This example illustrates the term Class and its instance variables (field), getter, setter, constructors
    //and additional methods

    public static void main(String[] args) {
        Wall w = new Wall(12,4);
        System.out.println("The wall area is "+ w.getArea());
    }
}
