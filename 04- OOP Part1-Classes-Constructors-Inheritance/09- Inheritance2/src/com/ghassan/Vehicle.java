package com.ghassan;

public class Vehicle {
    private int engineRpm;
    private int numberOfWheels;
    private int getNumberOWindows;
    private int numberOfGears;

    public Vehicle(int engineRpm, int numberOfWheels, int getNumberOWindows, int numberOfGears) {
        this.engineRpm = engineRpm;
        this.numberOfWheels = numberOfWheels;
        this.getNumberOWindows = getNumberOWindows;
        this.numberOfGears = numberOfGears;
    }

    public void changingGear(){
        System.out.println("Vehicle.changeGear()");
    }
    public void speed(){
        System.out.println("Vehicle.speed()");
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getGetNumberOWindows() {
        return getNumberOWindows;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }
}
