package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (if-else)
    public static void main(String[] args) {
	hasSharedDigit(123,124);
    }

    //this method check if 2 number has shared digit
    public static boolean hasSharedDigit(int digitOne, int digitTwo){
        int firstDigitOne = digitOne / 10;
        int secondDigitOne = digitOne % 10;
        int firstDigitTwo = digitTwo / 10;
        int secondDigitTwo = digitTwo % 10;

        if((digitOne < 10 || digitOne > 99) || (digitTwo < 10 || digitTwo > 99) ){
            System.out.println("Invalid");
            return false;
        }
        if((firstDigitOne == firstDigitTwo || firstDigitOne == secondDigitTwo) ||
                (secondDigitOne == firstDigitTwo || secondDigitOne == secondDigitTwo)){
            System.out.println("There is a shared digit");
            return true;
        }else {
            System.out.println("There is nooo shared digit");
            return false;
        }

    }
}
