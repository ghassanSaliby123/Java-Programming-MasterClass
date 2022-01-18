package com.ghassan;

public class Car extends Vehicle{
    private String brandName;
    private String model;
    private int numberOfseats;

    public Car(int engineRpm, int numberOfWheels, int getNumberOWindows, int numberOfGears,
               String brandName, String model, int numberOfseats) {
        super(engineRpm, numberOfWheels, getNumberOWindows, numberOfGears);
        this.brandName = brandName;
        this.model = model;
        this.numberOfseats = numberOfseats;
    }

    @Override
    public void changingGear() {
        System.out.println("Car.changeGear()");
    }

    @Override
    public void speed() {
        System.out.println("Car.speed()");
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfseats() {
        return numberOfseats;
    }
}
