package com.ghassan;

public class Main {
    //This simple provides explanations for the primitive types in Java
    //Using control flow statements and the Scanner object
    public static void main(String[] args) {
        System.out.println(
                Coloring.WHITE_BOLD_BRIGHT+"The Java programming language supports 8 " +
                " primitive data types. \nA primitive type is predefined by " +
                "the language and is named by a reserved keyword. \n" +
                "Primitive values do not share state with other primitive values. " +
                "\nThe eight primitive data types supported by the Java programming language are:"
                );
        PrimitiveTypes.menu();
        PrimitiveTypes.readInput();
    }

}
