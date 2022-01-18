package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (switch, if-else)
    public static void main(String[] args) {
        getDaysInMonth(2,2003);
        getDaysInMonth(2,2000);
        getDaysInMonth(3,2500);
        getDaysInMonth(2,1977);
    }

    //These methods get the days in month considering if the year is leap or not
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

    public static int getDaysInMonth(int month, int year) {
        if (year < 1 || year > 9999) {
            return -1;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
    }
}
