package com.ghassan;

public class Main {
    //This example illustrates the term Class and its instance variables (field), getter, setter, constructors
    //and additional methods
    // It provides simple information about a bank account and deposit/withdraw functions
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1234, 200, "Ghassan saliby",
                "ghghghg@gmail.com", "444555422");
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount("Ghassan");
        System.out.println("======================================");
        b1.deposit(12);
        b1.withdraw(300);
        b1.withdraw(200);
        System.out.println("======================================");
        b2.deposit(12);
        b2.withdraw(300);
        b2.withdraw(200);
        System.out.println("======================================");
        b3.deposit(12);
        b3.withdraw(300);
        b3.withdraw(200);
    }
}
