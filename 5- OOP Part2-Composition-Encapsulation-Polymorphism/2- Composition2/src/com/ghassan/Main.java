package com.ghassan;

public class Main {
    //This is another example for composition
    // Since Composition describes the HAS-A relationship
    //This example describes a BedRoom which has a Wall, Ceiling, Bed, and Lamp
    public static void main(String[] args) {
        Wall w1 = new Wall("left");
        Wall w2 = new Wall("right");
        Wall w3 = new Wall("front");
        Wall w4 = new Wall("rear");
        Ceiling ceiling = new Ceiling(4, 1);
        Lamp lamp = new Lamp("floor", true, 3);
        Bed bed = new Bed("Double", 2, 30, 2, 2);

        Bedroom bedroom = new Bedroom("BedRoom", w1, w2, w3, w4, ceiling, bed, lamp);
        bedroom.makeBed();
    }
}
