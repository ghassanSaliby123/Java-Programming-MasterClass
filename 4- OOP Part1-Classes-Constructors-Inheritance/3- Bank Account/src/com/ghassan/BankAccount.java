package com.ghassan;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this(123,123124.23,"Gh","2312","1234");
        System.out.println("Empty Constructor");
    }

    public BankAccount(String customerName) {
        this.customerName = customerName;
        this.accountNumber = 1234;
        this.balance = 2321.22;
        this.email = "12312";
        this.phoneNumber = "12345";
        System.out.println("Constructor with one field is called, the rest fields have default values ");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void deposit(double depositNumber) {
        System.out.println("The deposit is done successfully");
        this.balance += depositNumber;
        System.out.println("Your new balance is " + this.balance);
    }
    public void withdraw(double withdrawNumber){
        if(this.balance < withdrawNumber){
            System.out.println("You don't have enough money in your account");
        }else {
            System.out.println("The withdraw is done successfully");
            this.balance -= withdrawNumber;
            System.out.println("Your new balance is " + this.balance);
        }
    }
}
