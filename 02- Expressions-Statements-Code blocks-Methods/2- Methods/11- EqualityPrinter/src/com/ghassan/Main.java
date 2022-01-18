package com.ghassan;

public class Main {
    //This example is described in the Description text file
    public static void main(String[] args) {

        printEqual(12,234,41);
        printEqual(2,2,2);
        printEqual(2,3,2);

    }

    //This method checks if all the numbers are equal
    public static void printEqual(int n1, int n2, int n3) {
        if (n1 < 0 || n2 < 0 || n3 < 0) {
            System.out.println("Invalid Value");
        } else if (n1 == n2 && n1 == n3) {
            System.out.println("All numbers are equal");
        } else if (n1 == n2 || n2 == n3 || n1 == n3) {
            if (n1 != n2 || n2 != n3 || n1 != n3) {
                System.out.println("Neither all are equal or different");
            }

        } else if (n1 != n2 && n1 != n3 && n2 != n3) {
            System.out.println("All numbers are different");
        }


    }
}
