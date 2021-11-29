package com.ghassan;

public class Main {
    //This Example is described in the Description txt file
    public static void main(String[] args) {
        printYearsAndDays(7738943);
    }

    //This method print the year and day depending on the minutes inout
    public static void printYearsAndDays(long minutes){
        if(minutes < 0) {
            System.out.println("Invalid Value");
        }
        if (minutes >=0 && minutes < (24 * 60)){
            System.out.println(minutes + " min = 0 y and 0 d");
        }
        if(minutes >= 24 * 60 && minutes < 365 * 24 * 60 )
        {    long day = minutes / (24 * 60);
            System.out.println(minutes+ " min = 0 y and "+day+ " d");
        }
        if (minutes >= 365*24*60){
            long year = minutes / (365 * 24 * 60);
            long day = (minutes % (365*24*60)) / (24 * 60);
            System.out.println(minutes+ " min = "+year+ " y and "+day+ " d" );
        }

    }
}
