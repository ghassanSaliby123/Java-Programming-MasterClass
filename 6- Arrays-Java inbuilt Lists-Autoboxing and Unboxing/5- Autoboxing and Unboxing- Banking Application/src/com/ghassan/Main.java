package com.ghassan;

public class Main {
    //This example is described in the Description text file
    //It tends to illustrate the idea of Autoboxing and Unboxing (Wrappers) with ArrayLists
    //This example is about a baking application
    //Each back has branches which have lists of Customers who make transactions
    //The idea is to hide all the application functionalities and wrap them inside the Bank class
    //Bank -> Branches -> Customers
    public static void main(String[] args) {
        Bank bank = new Bank("ING");
        bank.addBranch("Belgium");
        bank.addCustomer("Belgium", "Ghassan", 20.23);
        bank.addCustomer("Belgium", "Saliby", 19.3);
        bank.addCustomer("Belgium", "Mark", 50);

        bank.addBranch("France");
        bank.addCustomer("France", "Sam", 100);

        bank.addCustomerTransaction("Belgium", "Ghassan", 221);
        bank.addCustomerTransaction("Belgium", "Ghassan", 1321);
        bank.addCustomerTransaction("France", "Sam", 100);

        bank.listCustomers("Belgium", true);
    }
}
