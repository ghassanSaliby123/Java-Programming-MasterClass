package com.ghassan;

public class Main {

    //This Example illustrates the method overloading in java and it is described in the description text file
    //Method overloading improves the code readability and re-usability
    //It is easier to remember one method name
    //Gives the flexibility to call a similar method with different types and number of data
    public static void main(String[] args) {
        System.out.println("Method overloading is the ability to write several methods with the same name " +
                "but with different signature.\n" +
                "The difference takes a place with the number of arguments and/or their types.\n" +
                "As a popular example for method overloading is the println method which has more " +
                "than 10 different implementations");

        System.out.println(area(2.5));
        System.out.println(area(12.3,13));
    }

    //These 2 methods calculate the area for different shapes and they have the same name
    //with different number of args and implementation
    public static double area (double radius){
        if(radius < 0 ){
            System.out.println("the radius is invalid");
            return -1.0;
        }else return radius * radius * Math.PI;
    }
    public static double area (double x, double y){
        if(x <0 || y <0){
            System.out.println("invalid values");
            return -1.0;
        }else
            return x * y;
    }
}
