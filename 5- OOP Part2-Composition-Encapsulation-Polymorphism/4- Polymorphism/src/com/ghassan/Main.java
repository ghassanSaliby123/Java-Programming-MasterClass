package com.ghassan;

public class Main {

    //The mechanism that allows actions to perform differently depending on the objet which implements them
    //This example illustrates the Polymorphism in java
    //We have a Car class which is extended by another three classes Mitsubishi,Holden and Ford
    //The latter classes have their own implementations for the methods which are extended from the Car class
    //These methods are startEngine, accelerate and brake.
    public static void main(String[] args) {
        Car car = new Car(4, "Car");
        Mitsubishi mitsubishi = new Mitsubishi(3, "mitsubishi");
        Holden holden = new Holden(5, "holden");
        Ford ford = new Ford(2, "ford");

        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());
        System.out.println("=================================");

        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());
        System.out.println("=================================");

        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
        System.out.println("=================================");

        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());
        System.out.println("=================================");
    }
}
