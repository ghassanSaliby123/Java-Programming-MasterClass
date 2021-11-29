package com.ghassan;

public class Main {
    //The Leap Year Converter example is described in the description text file
    public static void main(String[] args) {
        int year = 1700;
        System.out.println("Is the year " + year + " leap? " + isLeapYear(year));
    }

    //This method detect if the year is a leap one or not
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {

                    return true;
                } else return false;
            } else return true;
        } else return false;
    }
}
