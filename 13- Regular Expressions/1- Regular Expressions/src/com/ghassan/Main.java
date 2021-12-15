package com.ghassan;

import javax.sql.rowset.serial.SerialStruct;

public class Main {

    //A wildcard for any character is dot (.)
    //A boundary matcher (^) check the beginning of the string
    //A boundary matcher ($) check the end of the string
    //Check the appearance of characters []
    //Check the appearance of characters if they are followed by others [] []
    //When we use ^ inside [] it will negate the chars inside [] for EX [^ed] means
    //all chars except ed
    //We can use a range of chars [a-z3-9]
    //We can ignore case with (?i)[a-f]
    //We can match all digit through [0-9] or \\d
    //We can match all non digits through [a-z] or \\D
    //Match all the whitespace and newline though \\s
    //Match characters a-z , A-Z , 0-9 , _ through \\w
    //Match characters EXCEPT a-z , A-Z , 0-9 , _ through \\W
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
        System.out.println("Harry".replaceAll("[Hh]arry","Harry"));
        System.out.println("---------------------------------------------");
        //replace the appearance of all characters except several chars
        System.out.println("replace the appearance of characters except ej");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ([^ei]) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("[^ei]", "_"));
        System.out.println("---------------------------------------------");
        //replace a range of characters through [char - char] ...[a-z3-9]
        System.out.println("replace a range of characters through [char - char] ...[a-z3-9]");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ([a-f3-9]) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("[a-f3-9]", "_"));
        System.out.println("---------------------------------------------");
        //replace a range of characters through [char - char] ...[a-z3-9] with ignoring cases
        System.out.println("replace a range of characters through [char - char] ...[a-z3-9] with ignoring cases");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ((?i)[a-f3-9]) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-9]", "_"));
        System.out.println("---------------------------------------------");
        //replace any digit
        System.out.println("replace any digit");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ([0-9]]) or (\\d) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("[0-9]", "_"));
        System.out.println(alphanumeric.replaceAll("\\d", "_"));
        System.out.println("---------------------------------------------");
        //replace non digit
        System.out.println("replace non digit");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using ((?i)[a-z]]) or (\\D) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("(?i)[a-z]", "_"));
        System.out.println(alphanumeric.replaceAll("\\D", "_"));
        System.out.println("---------------------------------------------");
        //Remove whitespace and newline
        String hasWhiteSpace= "I have blanks and a\t tab and a newline\n";
        System.out.println("Remove whitespace and newline");
        System.out.println("The original String is : " + hasWhiteSpace);
        System.out.println("After using (\\s)  expression to replace it with _");
        System.out.println(hasWhiteSpace.replaceAll("\\s", "_"));
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println("---------------------------------------------");
        //replace a-z, A-z , 0-9 and _
        System.out.println("replace a-z, A-z , 0-9 and _ ");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (\\w) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("\\w", "_"));
        System.out.println("---------------------------------------------");
        //replace EXCEPT a-z, A-z , 0-9 and _
        System.out.println("replace EXCEPT a-z, A-z , 0-9 and _ ");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (\\W) expression to replace it with _");
        System.out.println(alphanumeric.replaceAll("\\W", "_"));
        System.out.println("---------------------------------------------");


    }
}
