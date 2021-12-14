package com.ghassan;

public class Main {

    //A wildcard for any character is dot (.)
    //A boundary matcher (^) check the beginning of the string
    //A boundary matcher ($) check the end of the string
    //Check the appearance of characters []
    //Check the appearance of characters if they are followed by others [] []
    public static void main(String[] args) {
	String string = "I am a string. Yes, I am";
        System.out.println(string);
        String yourString = string.replaceAll("I","You");
        System.out.println(yourString);
        System.out.println("---------------------------------------------");
        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        //replace all chars with Y using(.) wildcard
        System.out.println("replace all chars with Y using(.) wildcard...");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (.) expression");
        System.out.println(alphanumeric.replaceAll(".","Y"));
        System.out.println("---------------------------------------------");

        //replace the beginning characters using a boundary matcher ^
        System.out.println("replace the beginning characters using a boundary matcher ^ ");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (^abcDeee) expression to replace it with BEGINNING");
        System.out.println(alphanumeric.replaceAll("^abcDeee", "BEGINNING"));
        System.out.println("---------------------------------------------");

        //replace the ending characters using a boundary matcher $
        System.out.println("replace the ending characters using a boundary matcher $");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (ikl99z$) expression to replace it with END");
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "END"));
        System.out.println("---------------------------------------------");

        //replace the appearance of characters using []
        System.out.println("replace the appearance of characters using []");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ([aei]) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("[aei]", "_"));
        System.out.println("---------------------------------------------");

        //replace the appearance of characters if they are followed by other chars [] []
        System.out.println("replace the appearance of characters if they are followed by other chars [] []");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ([aei][Fj]) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "_"));
        System.out.println("---------------------------------------------");
    }
}
