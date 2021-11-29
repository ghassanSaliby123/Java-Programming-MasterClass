package com.ghassan;

public class Main {
    //This example is described in the description text file
    //It is illustrates the term Class and its instance variables (field), getter, setter
    //and additional methods
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        cal.setFirstNumber(120);
        cal.setSecondNumber(30);
        System.out.println("N1 + N2 = "+cal.getAdditionResult());
        System.out.println("N1 = N2 = "+cal.getSubtractionResult());
        System.out.println("N1 / N2 = "+cal.getDivisionResult());
        System.out.println("N1 * N2 = "+cal.getMultiplicationResult());
    }
}
