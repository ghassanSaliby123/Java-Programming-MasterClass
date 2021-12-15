package com.ghassan;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //We want to check the if the phone number has the following structure
    //(499) 123-4567
    public static void main(String[] args) {
	// ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        List<String> phoneBook = new ArrayList<>();

        String phoneNumber1 = "1233411";
        String phoneNumber2 = "(342) 131-3413";
        String phoneNumber3 = "(342)131-3413";
        String phoneNumber4 = "(342) 1313413";
        String phoneNumber5 = "(342) 131-341334";
        String phoneNumber6 = "(452) 333-7754";
        String phoneNumber7 = "(452) 333-77";
        String phoneNumber8 = "3341dfaf";
        String phoneNumber9 = "452 333-7745";
        String phoneNumber10 = "(452) 333-77da";

        phoneBook.add(phoneNumber1);
        phoneBook.add(phoneNumber2);
        phoneBook.add(phoneNumber3);
        phoneBook.add(phoneNumber4);
        phoneBook.add(phoneNumber5);
        phoneBook.add(phoneNumber6);
        phoneBook.add(phoneNumber7);
        phoneBook.add(phoneNumber8);
        phoneBook.add(phoneNumber9);
        phoneBook.add(phoneNumber10);

        for (String phoneNumber : phoneBook) {
            if (phoneNumber.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$")){
                System.out.println("The following number: "+ phoneNumber + " Match");
            }else {
                System.out.println("The following number: "+ phoneNumber + " Does Not Match");
            }
        }
    }
}
