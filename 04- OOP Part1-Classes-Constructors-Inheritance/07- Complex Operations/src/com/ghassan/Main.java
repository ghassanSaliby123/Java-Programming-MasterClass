package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    //This example illustrates the term Class and its instance variables (field), getter, setter, constructors
    //and additional methods
    //this example tends to find the cost of a carpet depending on the Floor area and the price
    // This example provide the addition and subtraction for 2 complex number
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(12, 24);
        ComplexNumber c2 = new ComplexNumber(33, 18);
        c1.add(c2);

        System.out.println("c1.real + c2.real = " + c1.getReal());
        System.out.println("c1.imaginary + c2.imaginary = " + c1.getImaginary());
        System.out.println("============================");
        c1.subtract(c2);
        System.out.println("c1.real - c2.real = " + c1.getReal());
        System.out.println("c1.imaginary - c2.imaginary = " + c1.getImaginary());
    }
}
