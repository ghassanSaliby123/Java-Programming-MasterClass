package com.ghassan;

public class Main {
    //The description of this example is in the Description text file
    // This example also explain the inheritance in java
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        Cuboid cuboid = new Cuboid(3, 4, 5);
        System.out.println("rectangle area is : " + rectangle.getArea());
        System.out.println("cuboid area is :" + cuboid.getArea());
        System.out.println("cuboid volume is :" + cuboid.getVolume());
    }
}
