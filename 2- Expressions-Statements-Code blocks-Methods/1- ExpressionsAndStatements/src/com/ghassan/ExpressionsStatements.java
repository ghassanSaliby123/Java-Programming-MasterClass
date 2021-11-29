package com.ghassan;

import java.util.Scanner;

public final class ExpressionsStatements {

    private ExpressionsStatements() {
    }

    public static void menu() {
        System.out.println(
                Coloring.BLUE_BOLD + "1- Expressions.\n" +
                        Coloring.PURPLE_BOLD + "2- Statements.\n" +
                        Coloring.GREEN_BOLD + "3- Blocks.\n" +
                        Coloring.YELLOW_BOLD + "4- Menu.\n" +
                        Coloring.RED_BOLD + "5- Exit.");
        System.out.println(Coloring.WHITE_BOLD_BRIGHT + "Press the corresponding number to " +
                "read more about the primitive types....");
    }

    public static int parseInput(String input) {
        int integerValue;
        try {
            integerValue = Integer.parseInt(input);
            if ((integerValue <= 10) && (integerValue > 0)) {
                return integerValue;
            } else {
                System.out.println(Coloring.RED_BOLD + "Please enter a number between 1 and 5.");
                return 0;
            }
        } catch (NumberFormatException e) {
            System.out.println(Coloring.RED_BOLD + "Please enter a number between 1 and 5.");
        }
        return -1;
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        try {
            while (condition) {
                String value = scanner.nextLine();
                if (parseInput(value) > 0) {
                    switch (parseInput(value)) {
                        case 1:
                            System.out.println(
                                    Coloring.WHITE_BOLD_BRIGHT + "Expressions: \n" +
                                            Coloring.WHITE_BRIGHT + "An expression is a construct made up of variables, operators, and " +
                                            "method invocations, \nwhich are constructed according to the syntax" +
                                            "of the language," + Coloring.BLUE_BOLD + "that evaluates to a single value.\n" +
                                            Coloring.WHITE_UNDERLINED + "The following are examples for expressions:\n" +
                                            Coloring.WHITE + "int " + Coloring.BLUE + "value = 1+2" + Coloring.WHITE + ";\n" +
                                            Coloring.WHITE + "if(" + Coloring.YELLOW + "value1 == value2" + Coloring.WHITE + ")\n" +
                                            Coloring.WHITE + "System.out.println(" + Coloring.GREEN + "\"This is an expression\"" + Coloring.WHITE + ");\n" +
                                            Coloring.WHITE + "int " + Coloring.PURPLE + "value = methodCall()" + Coloring.WHITE + ";\n" +
                                            Coloring.WHITE + "Object " + Coloring.CYAN + "obj = new Object()" + Coloring.WHITE + ";\n" +
                                            Coloring.BLUE + "value++" + Coloring.WHITE + ";\n"
                            );
                            break;
                        case 2:
                            System.out.println(
                                    Coloring.WHITE_BOLD_BRIGHT + "Statements: \n" +
                                            Coloring.WHITE_BRIGHT + "Statements are roughly equivalent to sentences in natural languages." +
                                            "A statement forms a complete unit of execution. " +
                                            "\nThe following types of expressions can be " +
                                            "made into a statement " + Coloring.PURPLE_BOLD + "by terminating the expression with a semicolon (;).\n" +
                                            "Those are called expression statements.\n" +
                                            Coloring.WHITE_UNDERLINED + "The following are examples for expression statements:\n" +
                                            Coloring.BLUE + "value = 1+2 ;\n" +
                                            Coloring.GREEN + "System.out.println(\"This is an expression\");\n" +
                                            Coloring.PURPLE + "value = methodCall();\n" +
                                            Coloring.CYAN + "Object obj = new Object();\n" +
                                            Coloring.BLUE + "value++;\n" +
                                            Coloring.WHITE_BRIGHT + "There are 2 other types of statements(declaration and Control flow) statements.\n" +
                                            Coloring.WHITE_UNDERLINED + "An example of the declaration statements is when we declare a variable:\n" +
                                            Coloring.BLUE + "int value = 1+2 ;\n" +
                                            Coloring.WHITE_UNDERLINED + "As for the control flow statements:\n" +
                                            Coloring.CYAN + "if-else, switch, for, while, do-while, break, continue, return\n" +
                                            Coloring.WHITE + "Which break up the flow of execution by employing decision making, looping, and branching. "
                            );
                            break;
                        case 3:
                            System.out.println(
                                    Coloring.WHITE_BOLD_BRIGHT + "Blocks: \n" +
                                            Coloring.WHITE_BRIGHT + "A block is a group of zero or more statements between " +
                                            "balanced braces and can be used anywhere a single statement is allowed.\n");
                            break;
                        case 4:
                            menu();
                            break;
                        case 5:
                            System.out.println("Exit...");
                            condition = false;
                            break;
                    }
                }
            }
        } finally {
            scanner.close();
        }


    }
}

