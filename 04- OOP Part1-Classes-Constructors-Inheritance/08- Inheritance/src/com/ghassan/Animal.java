package com.ghassan;

public class Animal {
    private String gender;
    private double height;
    private double weight;
    private double speed;
    private int numberOfLegs;


    public Animal(String gender, double height, double weight, double speed, int numberOfLegs) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.numberOfLegs = numberOfLegs;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getSpeed() {
        return speed;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    public void eat(){
        System.out.println("Animal.eat");
    }
    public void move(){
        System.out.println("Animal.move");
    }
}
