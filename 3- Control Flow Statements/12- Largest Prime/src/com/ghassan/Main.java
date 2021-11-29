package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (for, if-else,break)
    public static void main(String[] args) {
        getLargestPrime(217);
    }

    public static int getLargestPrime(int number) {
        boolean isDivided = false;
        if (number <= 1) {
            return -1;
        }
        int prime = 2;
        for (int i = 3; i <= number; i++) {
            isDivided = false;
            for (int j = 2; j <= i; j++) {
                if ((i % j == 0) && (i != j)) {
                    isDivided = true;
                    break;
                }
            }
            if (!isDivided && number % i == 0) {
                prime = i;
            }
        }
        System.out.println("The largest prime for " + number + " is = " + prime);
        return prime;
    }
}
