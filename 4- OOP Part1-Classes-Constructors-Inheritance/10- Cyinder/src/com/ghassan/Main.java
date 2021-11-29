package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    // This example also explain the inheritance in java
    public static void main(String[] args) {
        Circle circle = new Circle(2.33);
        Cylinder cylinder = new Cylinder(3.23, 10);
        System.out.println("The circle area is : " + circle.getArea());
        System.out.println("The cylinder area is :" + cylinder.getArea());
    }
}
