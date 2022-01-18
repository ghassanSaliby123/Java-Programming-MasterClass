package com.ghassan;

public class Main {
    //The SpeedConverter example is described in the description text file
    public static void main(String[] args) {
        printConversion(1.4);
        printConversion(20.32);
        printConversion(1100.0004);
        printConversion(232.22);
        printConversion(5.5);
        printConversion(74829.00003);
    }

    //This method convert Kilometers to Miles with using the Math.round method
    // 1 mile = 1.609 kilometer
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        return Math.round(kilometersPerHour / 1.609);
    }

    //This method should calculate milesPerHour from the kilometersPerHour parameter.
    //Then it needs to print a message in the format "XX km/h = YY mi/h".
    public static void printConversion(double kilometerPerHour) {
        if (kilometerPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour = toMilesPerHour(kilometerPerHour);
            System.out.println(kilometerPerHour +
                    " km/h = " + milesPerHour + " mi/h");
        }
    }
}
