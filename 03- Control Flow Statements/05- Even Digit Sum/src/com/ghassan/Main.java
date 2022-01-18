package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (while, if-else)
    public static void main(String[] args) {
	getEvenDigitSum(1234553324);
    getEvenDigitSum(2412111);
    getEvenDigitSum(33333);

    }

    //This method calculates the even digits within a number
    public static int getEvenDigitSum(int number){
        int original = number;
        int reverse = 0;
        int sum = 0;
        if(number < 0){
            return -1;
        }
        while(number != 0){
            reverse = number % 10;
            if(reverse % 2 == 0) {
                sum += reverse;
            }
            number /= 10;
        }
        System.out.println("The sum for even digits in the number "+ original+
                " is :" + sum);
        return sum;
    }
}
