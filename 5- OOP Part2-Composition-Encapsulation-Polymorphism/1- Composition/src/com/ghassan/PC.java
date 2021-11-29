package com.ghassan;

public class PC {
    //Here we can find the Composition HAS A relationship
    //Pc has a case, motherboard and monitor
    private Case theCase;
    private MotherBoard motherBoard;
    private Monitor monitor;

    public PC(Case theCase, MotherBoard motherBoard, Monitor monitor) {
        this.theCase = theCase;
        this.motherBoard = motherBoard;
        this.monitor = monitor;
    }

    public Case getTheCase() {
        return theCase;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
