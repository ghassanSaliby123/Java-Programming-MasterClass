package com.ghassan;

public class Main {

    //As we already know the Inheritance reflects the IS-A relationship such as a Car IS-A Vehicle
    //The Composition in java describes the relationship HAS-A, for example a Car HAS-An Engine
    //Both Car and Engine are different classes and the Engine object will act
    // as a field for the Car object
    //In this example we will illustrate the Composition through a PC example
    //The PC HAS A MotherBoard, Case, and Monitor
    public static void main(String[] args) {
	Case theCase = new Case("22v","HP","220");
    Monitor monitor = new Monitor("300","HP",32);
    MotherBoard motherBoard = new MotherBoard("32B","Intel",2,4);

    PC pc = new PC(theCase,motherBoard, monitor);

    pc.getTheCase().pressPower();
    pc.getMonitor().draw(232,333,"red");
    pc.getMotherBoard().loadProgram("Excel");
    }
}
