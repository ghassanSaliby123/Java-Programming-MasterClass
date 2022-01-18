package com.ghassan;

public class Main {
    // This example illustrate the inheritance in java
    // Generally speaking,inheritance is explained with an IS-A relationship
    // Several inherits Vehicle-> Car-> Specific type of car
    //How to deal with overwrite methods
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(2000, 4, 4, 4);
        Car car = new Car(3000, 4,
                4, 4, "Car", "123", 4);
        Porsche porsche = new Porsche("CCC");
        vehicle.speed();
        vehicle.changingGear();
        System.out.println("----------------------");
        car.speed();
        car.changingGear();
        System.out.println("----------------------");
        porsche.speed();
        porsche.changingGear();
    }
}
