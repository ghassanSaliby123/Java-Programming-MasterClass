package com.ghassan;

public class Dog extends Animal{
    private String type;
    private boolean homeDog;
    private boolean securityDog;

    public Dog(String gender, double height, double weight, double speed,
               String type, boolean homeDog, boolean securityDog) {
        super(gender, height, weight, speed, 4);
        this.type= "Hasky";
        this.homeDog = true;
        this.securityDog = false;
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat");
    }

    @Override
    public void move() {
        System.out.println("Dog.move");
    }
}
