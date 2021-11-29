package com.ghassan;

public class Main {
    // This example illustrate the inheritance in java
    // Generally speaking,inheritance is explained with an IS-A relationship
    //In this example we provide Animal class which has different properties
    //and other Classes that share the same properties such as Dog, Cat..
    //Since the Dog IS An Animal. So instead of rewriting the Animal properties inside the Dog Class
    // We simply make the Dog class inherent from the Animal class which the latter then called a Supper Class
    //And the Dog Class is called a SubClass
    public static void main(String[] args) {

        Animal animal = new Animal("male",1,20,24,4);
        Dog dog = new Dog("female",1,20,34,
                "shepherd",false,true);
        animal.eat();
        animal.move();
        dog.eat();
        dog.move();
    }
}
