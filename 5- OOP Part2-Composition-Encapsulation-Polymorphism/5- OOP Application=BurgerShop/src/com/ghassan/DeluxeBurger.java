package com.ghassan;



public class DeluxeBurger extends Hamburger{
    public DeluxeBurger() {
        super("Deluxe", "Suasge & Bacon ", 14.54, "White");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drink", 2.14);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add addition items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add addition items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add addition items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add addition items to a deluxe Burger");
    }
}

