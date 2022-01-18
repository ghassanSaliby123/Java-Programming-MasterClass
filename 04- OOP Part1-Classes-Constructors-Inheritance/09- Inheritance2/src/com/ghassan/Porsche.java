package com.ghassan;

public class Porsche extends Car {
    private String carModel;

    public Porsche(String carModel) {
        super(2400, 4, 4,
                5, "Porsche", "sport car", 4);
        this.carModel = carModel;
    }

    @Override
    public void changingGear() {
        System.out.println("Porsche.changingGear()");
    }

    @Override
    public void speed() {
        System.out.println("Porsche.speed()");
    }

    public String getCarModel() {
        return carModel;
    }
}
