package com.ghassan;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;

    public Monitor(String model, String manufacturer, int size) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
    }

    public void draw(int x, int y, String color) {
        System.out.println("Draw a pixel on " + x + "," + y + " with color " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }
}
