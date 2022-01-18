package com.ghassan;

public class Main {
    //This example is described in the description text file
    //Example of using the control flow statements (switch, while,if-else, for)
    public static void main(String[] args) {
	numberToWords(12345);
    }

    //These methods convert the number into words
    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
        }else {
            int newNumber = reverse(number);
            int count = getDigitCount(number);
            int digit = 0;
            System.out.println("The number "+ number + " is written as:");
            while (count != 0) {
                digit = newNumber % 10;
                newNumber /= 10;
                switch (digit) {
                    case 0:
                        System.out.print(" Zero ");
                        break;
                    case 1:
                        System.out.print(" One ");
                        break;
                    case 2:
                        System.out.print(" Two ");
                        break;
                    case 3:
                        System.out.print(" Three ");
                        break;
                    case 4:
                        System.out.print(" Four ");
                        break;
                    case 5:
                        System.out.print(" Five ");
                        break;
                    case 6:
                        System.out.print(" Six ");
                        break;
                    case 7:
                        System.out.print(" Seven ");
                        break;
                    case 8:
                        System.out.print(" Eight ");
                        break;
                    case 9:
                        System.out.print(" Nine ");
                        break;
                    default:
                        System.out.print(" Zero ");
                }
                count--;
            }
        }
    }
    public static int reverse(int number){
        int count = getDigitCount(number);
        int rev = 0;
        for(int i = 1; number != 0 ; i++){
            rev = (rev * 10) + number % 10;
            number /= 10;
        }
        return rev;
    }
    public static int getDigitCount(int number){
        int count = 0;
        if(number == 0){
            count = 1;
        }
        else if(number < 0){
            count = -1;
        }else{
            while(number != 0){
                number /= 10;
                count++;
            } }
        return count;
    }
}
