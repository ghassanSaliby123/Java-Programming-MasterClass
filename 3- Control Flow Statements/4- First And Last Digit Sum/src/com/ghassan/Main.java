package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (while, if-else)
    public static void main(String[] args) {
        sumFirstAndLastDigit(1231);
        sumFirstAndLastDigit(2);
        sumFirstAndLastDigit(34321);
        sumFirstAndLastDigit(9341);
    }

    //This method sums the first and the last digits of each number
    public static int sumFirstAndLastDigit(int number) {
        int lastDigit = number % 10;
        if (number < 0) {
            return -1;
        }
        while (number >= 10) {
            number /= 10;
        }
        return number + lastDigit;
    }
}
