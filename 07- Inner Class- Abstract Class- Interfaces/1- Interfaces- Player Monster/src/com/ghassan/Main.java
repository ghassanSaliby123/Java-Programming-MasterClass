package com.ghassan;

public class Main {

    //Interface is a structure that includes only abstract methods (without implementation) except cases
    // with java 8 or higher when the method might have an implementation, but it should be declared
    // as default. In general, interfaces behave as contract which is signed by the class which implement it
    // and this class should guarantee to provide implementations for all the abstract methods in the
    // interface.
    //Interfaces also act as types for example we have an interface I and a class C which implement
    // We can declare an object of C with type I.
    // I inter = new C();
    // If we have several classes B, D , E all implement I, we can write:
    // I ineter1= new B();
    // I ineter2= new D();
    // I ineter3= new E();

    //This example is described in the Description text file
    public static void main(String[] args) {

    }
    public static void savedObject(ISaveable saveableObject){
        for (int i = 0; i <saveableObject.write().size(); i++) {
            System.out.println("Saving "+saveableObject.write().get(i)+ " to storage");
        }
    }
}
