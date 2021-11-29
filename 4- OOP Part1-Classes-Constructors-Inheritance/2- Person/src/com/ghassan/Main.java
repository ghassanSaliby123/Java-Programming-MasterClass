package com.ghassan;

public class Main {
    //This example is described in the description text file
    //It is illustrates the term Class and its instance variables (field), getter, setter
    //and additional methods,
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setFirstName("Ghassan");
        p1.setLastName("Saliby");
        p1.setAge(31);
        System.out.println("Is the person with the name " + p1.getFullName() + " a teen? " + p1.isTeen());
    }
}
