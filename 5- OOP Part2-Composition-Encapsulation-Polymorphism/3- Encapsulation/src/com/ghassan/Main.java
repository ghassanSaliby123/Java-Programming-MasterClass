package com.ghassan;

public class Main {

    //Encapsulation is mechanism that restrict access to a component in an object
    //Protecting a component from unauthorized access
    //This example is about a Printer and through is we demonstrate the encapsulation techniques
    //This example will simulate a real computer printer. it should determine the toner level, number
    // of pages to print, printing on one side or 2 sides of the page.
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("Initial page count =" + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total printed pages is "
                + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + " new total printed pages is "
                + printer.getPagesPrinted());
    }
}
