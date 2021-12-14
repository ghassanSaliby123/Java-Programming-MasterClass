package com.ghassan;

import java.io.LineNumberInputStream;
import java.util.*;

public class Main {

    //Lambda provide easier way to deal with interfaces that have only one method
    //which are called functional interfaces
    //This example is an introduction to Lambda and using it with sort collections
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

        //Sorting the list with anonymous class Comparator
        System.out.println("1- Sorting the list with anonymous class Comparator.......");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println("============================================================");
        //Write the compare method in Comparator with lambda
        System.out.println("2- Write the compare method in Comparator with lambda");
        Collections.sort(employees,(Employee o1, Employee o2)->
                o1.getName().compareTo(o2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println("==============================================================");
        //Using Anonymous class to implement the  with methods that return values
        System.out.println("3- Using Anonymous class to implement the  with methods that return values");
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
        System.out.println("==============================================================");

        //Using lambda to implement the upperAndConcat method
        System.out.println("4- Using lambda to implement the upperAndConcat method ");
        UpperConcat uc = (String s1, String s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString2 = doStringStuff(uc, employees.get(0).getName(),employees.get(1).getName());
        System.out.println(sillyString2);
        System.out.println("==============================================================");

        AnotherClass anotherClass = new AnotherClass();
        String s= anotherClass.doSomething();
        System.out.println(s);

    }

    //Get the result from UpperConcat interface
    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }

    private static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    interface UpperConcat{
        //Convert to string to upper case and concat them
        public String upperAndConcat(String s1, String s2);
    }
}

class AnotherClass{
    public String doSomething(){
        Main.UpperConcat uc = ((s1, s2) ->{
            System.out.println("The lambda expression class is :"+getClass().getSimpleName());
            String result = s1.toLowerCase() + s2.toUpperCase();
            return result;
        });
        System.out.println("The AnotherClass name is :"+ getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
//        System.out.println("The AnotherClass class name is: "+ getClass().getSimpleName());
//        return Main.doStringStuff(new Main.UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class name is: "+ getClass().getSimpleName());
//
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1","String2");

    }
}


