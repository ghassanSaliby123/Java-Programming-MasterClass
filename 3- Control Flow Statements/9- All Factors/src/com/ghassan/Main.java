package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (for, if-else)
    public static void main(String[] args) {
        printFactors(13);
        printFactors(44);
    }

    //This method prints all the factor of the number(a factor is a divider without leaving a remainder)
    public static void printFactors(int number){
        if(number < 1){
            System.out.println("Invalid Value");
        }else {
            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    System.out.println("The number "+i+ " is a factor of "+number);
                }
            }
            System.out.println("The number "+number+ " is a factor of "+number);
        }
    }
}
