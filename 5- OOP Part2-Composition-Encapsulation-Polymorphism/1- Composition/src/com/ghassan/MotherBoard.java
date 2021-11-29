package com.ghassan;

public class MotherBoard {
    private String model;
    private String manufacturer;
    private int ramSlots;
    private int cardSlots;

    public MotherBoard(String model, String manufacturer, int ramSlots, int cardSlots) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public void loadProgram(String programName) {
        System.out.println("Loading the program " + programName + ".....");
    }

}
