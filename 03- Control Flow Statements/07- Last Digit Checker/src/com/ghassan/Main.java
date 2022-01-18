package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (if-else)
    public static void main(String[] args) {
        
    }

    //These methods check whether al least 2 numbers share their last digit
    public static boolean hasSameLastDigit(int numberOne, int numberTwo, int numberThree){
        int lastNumberNumberOne = numberOne % 10;
        int lastNumberNumberTwo = numberTwo % 10;
        int lastNumberNumberThree = numberThree % 10;
        if(!(isValid(numberOne)) || !(isValid(numberTwo)) || !(isValid(numberThree))){
            System.out.println("There is Invalid value");
            return false;
        }
        if(lastNumberNumberOne == lastNumberNumberTwo || lastNumberNumberOne == lastNumberNumberThree
                || lastNumberNumberTwo == lastNumberNumberThree){
            System.out.println("There is a same digit");
            return true;
        }else return false;
    }

    public static boolean isValid(int number){
        if((number < 10) || (number > 1000)){
            return false;
        }else return true;
    }
}
