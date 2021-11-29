package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    //This example illustrates the term Class and its instance variables (field), getter, setter, constructors
    //and additional methods
    //this example tends to find the distance between 2 points
    //d(A,B)=√ (xB − xA) * (xB - xA) + (yB − yA) * (yB - yA)
    public static void main(String[] args) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(5, 119);
        System.out.println("The distance between P1 and P2 is : " + p1.distance(p2));
    }
}
