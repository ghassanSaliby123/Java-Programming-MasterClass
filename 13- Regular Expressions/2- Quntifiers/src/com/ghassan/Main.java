package com.ghassan;

import javax.sql.rowset.serial.SerialStruct;

public class Main {

    //Quantifiers determine how often an element can occur
    //Match with n times of appearance asd{n} .. n is a number
    //Match with 1 or more appearance asd+
    //Optional appearance with 0 or more asd*
    //Match with a range of appearance asd{3,5}. Here d should appear between 3 to 5 times
    public static void main(String[] args) {
        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        //using quantifier to determine how often a char should appear
        System.out.println("using quantifier to determine how often a char should appear");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (^abcDe{3}) expression");
        System.out.println(alphanumeric.replaceAll("^abcDe{3}","_"));
        System.out.println("---------------------------------------------");
        //using + quantifier for 1 or more appearance
        System.out.println("using + quantifier for 1 or more appearance");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (^abcDe+) expression");
        System.out.println(alphanumeric.replaceAll("^abcDe+","_"));
        System.out.println("---------------------------------------------");
        //using * quantifier for 0 or more appearance
        System.out.println("using + quantifier for 0 or more appearance");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (^abcDe*) expression");
        System.out.println(alphanumeric.replaceAll("^abcDe*","_"));
        System.out.println("---------------------------------------------");
        //Match with a range of appearance {n1 to n2}
        System.out.println("Match with a range of appearance {n1 to n2}");
        System.out.println("The original String is : " + alphanumeric);
        System.out.println("After using (^abcDe{2,5}) expression");
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}","_"));
        System.out.println("---------------------------------------------");
        System.out.println(alphanumeric.replaceAll("h+i*j","_"));



    }
}
