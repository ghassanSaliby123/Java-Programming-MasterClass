package com.ghassan;

public class Main {

    //This example is described in the description text file
    //Example of using the control flow statements (for, if-else)
    public static void main(String[] args) {
	isPerfectNumber(6);
    isPerfectNumber(17);
    isPerfectNumber(28);
    isPerfectNumber(12);
    }

    //This method checks whether the number is perfect or not
    //The perfect number is a positive integer which is equal to the sum of its proper positive divisors.
    //For example number 1,2,3 are the divisors for 6 and 1+2+3 = 6, so 6 is a perfect number
    public static boolean isPerfectNumber(int number){
        int sum = 0;
        if(number < 1){
            System.out.println("Invalid input");
            return false;
        }
        for(int i = 1;i <= number / 2; i++ ){
            if(number % i == 0){
                sum += i ;
            }
        }
        if(sum == number){
            System.out.println("The number "+number+" is a perfect number");
            return true;
        }else {
            System.out.println("The number "+number+" is not a perfect number");
            return false;
        }
    }
}
