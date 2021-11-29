package com.ghassan;

public class Main {

    //This Example illustrates the method overloading in java.
    //Method overloading improves the code readability and re-usability
    //It is easier to remember one method name
    //Gives the flexibility to call a similar method with different types and number of data
    public static void main(String[] args) {
        System.out.println("Method overloading is the ability to write several methods with the same name " +
                "but with different signature.\n" +
                "The difference takes a place with the number of arguments and/or their types.\n" +
                "As a popular example for method overloading is the println method which has more " +
                "than 10 different implementations");


        getDurationString(130,30);
        getDurationString(1234);
    }

    //These 2 methods print the time in the following format XXh YYm ZZs
    //with different number of args and implementation
    //The first one takes the min and sec, the second one takes only the seconds
    public static void getDurationString (int min, int sec){
        if((min > 0) && (sec <= 59) && (sec > 0)){
            int newHour = min / 60;
            int newMin = min % 60;
            System.out.println(newHour+"h "+newMin+"m "+sec+"s.");
        }else {
            System.out.println("Invalid Input");
        }
    }
    public static void getDurationString (int sec){
        if(sec >=0){
            int min = sec / 60;
            int newSec = sec % 60;
            getDurationString(min,newSec);
        }else {
            System.out.println("Invalid Input");
        }
    }
}
