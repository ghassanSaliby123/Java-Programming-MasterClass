package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    //This example illustrates the term Class and its instance variables (field), getter, setter, constructors
    //and additional methods
    //this example tends to find the cost of a carpet depending on the Floor area and the price
    // We use a composition to solve this example, which means using the Floor and the Carpet objects
    //as instance variables for the Calculator class
    public static void main(String[] args) {
        Floor f = new Floor(3, 4);
        Carpet c = new Carpet(12.23);
        Calculator cal = new Calculator(f, c);
        System.out.println("The total carpet cost for this floor is :" + cal.getTotalCost());
    }
}
