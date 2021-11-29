package com.ghassan;
import java.util.Scanner;

public final class PrimitiveTypes {

    private PrimitiveTypes() {
    }

    public static void menu(){
        System.out.println(
                Coloring.BLUE_BOLD+"1- Byte.\n" +
                        Coloring.PURPLE_BOLD+"2- Short.\n" +
                        Coloring.GREEN_BOLD+"3- int.\n" +
                        Coloring.WHITE_BOLD+"4- Long.\n" +
                        Coloring.YELLOW_BOLD+"5- float.\n" +
                        Coloring.WHITE_BOLD+"6- Double.\n"+
                        Coloring.CYAN_BOLD+"7- Boolean.\n"+
                        Coloring.YELLOW_BOLD+"8- Char.\n" +
                        Coloring.BLUE_BOLD+ "9- Menu.\n"+
                        Coloring.RED_BOLD+ "10- Exit.");
        System.out.println(Coloring.WHITE_BOLD_BRIGHT+"Press the corresponding number to " +
                "read more about the primitive types....");
    }

    public static int parseInput(String input){
        int integerValue;
        try {
            integerValue = Integer.parseInt(input);
            if((integerValue <= 10 ) && (integerValue > 0)){
                return integerValue;
            }else {
                System.out.println( Coloring.RED_BOLD+"Please enter a number between 1 and 10.");
                return 0;
            }
        }catch (NumberFormatException e){
            System.out.println( Coloring.RED_BOLD+"Please enter a number between 1 and 10.");
        }
        return -1;
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
            try {
                while (condition){
                    String value = scanner.nextLine();
                    if (parseInput(value) > 0) {
                        switch (parseInput(value) ) {
                            case 1:
                                System.out.println(
                                        Coloring.BLUE_BOLD+"Byte: \n"+ " The byte data type is an 8-bit signed two's " +
                                                "complement integer.\n" +" It has a minimum value of " + Byte.MIN_VALUE +
                                                " and a maximum value of "+ Byte.MAX_VALUE +
                                                " \n The byte data type can be useful for saving memory in large arrays," +
                                                " where the memory savings actually matters.\n" +
                                                " They can also be used in place of int where their limits help to clarify your code\n");
                                break;
                            case 2:
                                System.out.println(
                                        Coloring.PURPLE_BOLD+"Short:\n"+
                                                "The short data type is a 16-bit signed two's complement integer.\n" +
                                                "It has a minimum value of " + Short.MIN_VALUE +" and a maximum value of "+ Short.MAX_VALUE +
                                                " \nyou can use a short to save memory in large arrays," +
                                                " in situations where the memory savings actually matters.\n");
                                break;
                            case 3 :
                                System.out.println(
                                        Coloring.GREEN_BOLD+"Int:\n"+
                                                "The int data type is a 32-bit signed two's complement integer.\n" +
                                                "It has a minimum value of " + Integer.MIN_VALUE +
                                                " and a maximum value of " +Integer.MAX_VALUE +
                                                "\nyou can use the int data type to represent an unsigned 32-bit integer" +
                                                "which has a minimum value of 0 and a maximum value of 232-1.\n" +
                                                "Use the Integer class to use int data type as an unsigned integer. \n");
                                break;
                            case 4 :
                                System.out.println(
                                        Coloring.WHITE_BOLD+"Long:\n" +
                                                "The long data type is a 64-bit two's complement integer.\n" +
                                                "It has a minimum value of " + Long.MIN_VALUE +
                                                " and a maximum value of " +Long.MAX_VALUE +
                                                "\nyou can use the long data type to represent an " +
                                                "unsigned 64-bit long, which has a minimum value of 0 and a maximum value " +
                                                "of 264-1." +
                                                "\nUse this data type when you need a range of values wider than " +
                                                "those provided by int.\n");
                                break;
                            case 5:
                                System.out.println(
                                        Coloring.YELLOW_BOLD+"Float:\n" +
                                                "The float data type is a single-precision 32-bit IEEE 754 floating point.\n" +
                                                "It has a minimum value of " + Float.MIN_VALUE +
                                                " and a maximum value of " +Float.MAX_VALUE +
                                                "\nAs with the recommendations for byte " +
                                                "and short, use a float (instead of double) if you need to save memory in " +
                                                "large arrays of floating point numbers.\n" );
                                break;
                            case 6:
                                System.out.println(
                                        Coloring.WHITE_BOLD+"Double:\n"+
                                                "The double data type is a double-precision 64-bit IEEE 754 floating point.\n" +
                                                "It has a minimum value of " + Double.MIN_VALUE +
                                                " and a maximum value of " +Double.MAX_VALUE +
                                                "\nFor decimal values, this data type is generally " +
                                                "the default choice.\n");
                                break;
                            case 7:
                                System.out.println(
                                        Coloring.CYAN_BOLD+"Boolean:\n"+
                                                "The boolean data type has only two possible values: true and false.\n"+
                                                "Use this data type for simple flags that track true/false" +
                                                " conditions. " +
                                                "\nThis data type represents one bit of information\n" );
                                break;
                            case 8:
                                System.out.println(
                                        Coloring.YELLOW_BOLD+"Char:\n" +
                                                "The char data type is a single 16-bit Unicode character.\n" +
                                                "It has a minimum value of " + Character.MIN_VALUE +
                                                " and a maximum value of " +Character.MAX_VALUE +"\n" );
                                break;
                            case 9:
                                menu();
                                break;
                            case 10:
                                System.out.println("Exit...");
                                condition = false;
                                break;
                        }
                    }
                }
            }finally {
                scanner.close();
            }


    }
}
