package com.ghassan;

public class Main {
    //This simple program illustrates the terms of expressions, statements and blocks in java
    //Using control flow statements and Scanner object
    //1- Provide coloring to the text.
    //2- Print the primitive type list.
    //3- Validate the user input.
    public static void main(String[] args) {
        System.out.println(
                Coloring.WHITE_BOLD_BRIGHT + "This code example describes the differences between" +
                        "the Expressions and the Statements in java, moreover, it describes the Blocks.");

        ExpressionsStatements.menu();
        ExpressionsStatements.readInput();
    }
}
