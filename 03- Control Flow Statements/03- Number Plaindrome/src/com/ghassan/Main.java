package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (while, if-else)
    public static void main(String[] args) {
	isPalindrome(12345);
    isPalindrome(0);
    isPalindrome(1221);

    }
    //This method check if the number is Palindrome number which means the reverse
    // of this number is equal to the original number
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int currentNumber = number;
        while(number != 0){
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }
        if(reverse == currentNumber){
            System.out.println(currentNumber+": This is a Palindrome number");
            return true;
        }else{
            System.out.println(currentNumber+": This is not a Palindrome number");
            return false;
        }
    }
}
