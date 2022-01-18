package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (for, if-else)
    public static void main(String[] args) {
	getGreatestCommonDivisor(24,60);
    getGreatestCommonDivisor(300,120);
    }

    //This method find the GCD for 2 numbers
    public static int getGreatestCommonDivisor(int first, int second){
        int last = 0;
        if(first < 10 || second < 10){
            System.out.println("Invalid value");
            return -1;
        }

        for(int i = 1; i <= first && i <= second ; i++ ){
            if((first % i == 0) && (second % i ==0)){
                if(i > last) {
                    last = i;
                }
            }

        }
        System.out.println("The GCD for "+ first + "and "+ second + " is :"+ last);
        return last;
    }
}
