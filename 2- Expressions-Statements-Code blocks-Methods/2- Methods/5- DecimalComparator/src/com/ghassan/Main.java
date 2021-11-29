package com.ghassan;

public class Main {

    //The Leap Year DecimalComparator example is described in the description text file
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.1123, -3.112));
    }

    //This method compares 2 numbers with three decimal places
    public static boolean areEqualByThreeDecimalPlaces(double d1, double d2) {
        int value1 = (int) (d1 * 1000);
        int value2 = (int) (d2 * 1000);
        if (value1 == value2) {
            return true;
        } else {
            return false;
        }
    }
}
