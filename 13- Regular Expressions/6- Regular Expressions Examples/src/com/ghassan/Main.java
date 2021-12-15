package com.ghassan;

public class Main {

    //This code contains several examples for RE
    public static void main(String[] args) {
	    // RE that matches the following sentence "I want a bike."
        System.out.println("1- Regular expression that matches the following sentence \"I want a bike.\"");
        String example1 = "I want a bike.";
        String regularExpression1= "I want a bike.";
        System.out.println("The regular expression is: "+ regularExpression1 );
        System.out.println(example1.matches(regularExpression1));
        System.out.println("=======================================");
        // RE that matches the following sentences "I want a bike." and "I want a ball."
        //"I want ...."
        System.out.println("2- Regular expression that matches the following sentence \"I want a WORD.\"");
        String example2 = "I want a ball.";
        String regularExpression2= "I want a \\w+.";
        System.out.println("The regular expression is: "+ regularExpression2 );
        System.out.println(example2.matches(regularExpression2));
        System.out.println("=======================================");

        // RE that replace all blanks with _
        System.out.println("3- Regular expression that replace all blanks with _ ");
        String example3 = "Replace the blanks with underscore";
        String regularExpression3= "\\s";
        System.out.println(example3);
        System.out.println("The regular expression is: "+ regularExpression3);
        System.out.println(example3.replaceAll(regularExpression3,"_"));
        System.out.println("=======================================");

        // RE that match aaabccccccccdddeffg
        System.out.println("4- Regular expression that match aaabccccccccdddeffg ");
        String example4 = "aaabccccccccdddeffg";
        String regularExpression4= "[a-g]+";
        System.out.println(example4);
        System.out.println("The regular expression is: "+ regularExpression4);
        System.out.println(example4.matches(regularExpression4));
        System.out.println("=======================================");

        // RE that match letters followed by period followed by digits adas.2312
        System.out.println("5- Regular expression that match letters followed by period followed by digits adas.2312 ");
        String example5 = "adafaf.2142341134";
        String regularExpression5= "[a-z]+\\.\\d+";
        System.out.println(example5);
        System.out.println("The regular expression is: "+ regularExpression5);
        System.out.println(example5.matches(regularExpression5));
        System.out.println("=======================================");


    }
}
