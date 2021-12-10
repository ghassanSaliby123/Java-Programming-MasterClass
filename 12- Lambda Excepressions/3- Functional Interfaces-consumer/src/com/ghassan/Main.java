package com.ghassan;

import java.io.LineNumberInputStream;
import java.util.*;

public class Main {

    //Through this example we start discussing the functional interfaces which are
    //the interfaces that have one method needs to be implemented
    //(it might have other methods, but it should have implementation, and it should be declared as default)
    //The Consumer interface is a functional one. It has two functions accept, andThen
    //The andThen method has a default implementation, and we should implement the accept method
    //The accept method tends to perform an action on its parameter and return nothing
    //The Consumer interface is used as an argument for the foreach method, and we can use it with lambda
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ghassan", 30);
        Employee employee2 = new Employee("Fadi", 35);
        Employee employee3 = new Employee("Nanar", 30);
        Employee employee4 = new Employee("Rita", 23);
        Employee employee5 = new Employee("Melad", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        //Print the employees names with the enhanced for loop
        System.out.println("1- Print the employees names with the enhanced for loop");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println("============================================");

        //Print the employees names with the foreach loop with a Consumer as an argument
        System.out.println("2- Print the employees names with the foreach loop with a Consumer as an argument");
        employees.forEach(employee -> {
            System.out.println(employee.getName());
        });
        System.out.println("============================================");

        //Print the employees names who their age is over 30 using the foreach loop with Consumer
        System.out.println("3- Print the employees names who their age is over 30 using the foreach loop with Consumer");
        employees.forEach(employee -> {
            if (employee.getAge() >= 30){
                System.out.println(employee.getName() + " -> "+ employee.getAge());
            }
        });

    }
}



