package com.ghassan;

import java.util.Scanner;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements with reading the user input through Scanner
    public static void main(String[] args) {
	inputThenPrintSumAndAverage();
    }

    //This method reads the user input and sum it if int and terminate if non int
    public static void inputThenPrintSumAndAverage(){
        int sum = 0;
        long avg = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter a number :");
            boolean hasInt = scanner.hasNextInt();
            if(hasInt){
                int number = scanner.nextInt();
                count++;
                sum += number;
            }else {
                System.out.println("You entered invalid value");
                break;
            }
            scanner.nextLine();
        }
        double x = (double) sum / count;
        avg = Math.round(x);
        System.out.println("SUM = "+sum +" AVG = " + avg );
        scanner.close();
    }
}
