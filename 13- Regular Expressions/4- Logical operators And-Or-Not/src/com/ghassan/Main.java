package com.ghassan;


public class Main {
    //Using And, Or, Not
    //And:We can use And implicitly such as "abc" means "a" and "b" and "c"
    //Or: We can use it with brackets such [Hh] or [H|h] means "H" or "h"
    //Not: using ^ within []
    public static void main(String[] args) {

        //And ,abc (replace "a followed by b followed by c)
        System.out.println("abcdfecsd".replaceAll("abc","_"));
        System.out.println("==============================================");
        //Or, [abc] (replace a or b or c )
        System.out.println("abcdfecsd".replaceAll("[a|b|c]","_"));
        System.out.println("==============================================");
        //Not, [^abc] (replace all except abc)
        System.out.println("abcdfecsd".replaceAll("[^abc]","_"));
        System.out.println("==============================================");


    }
}
