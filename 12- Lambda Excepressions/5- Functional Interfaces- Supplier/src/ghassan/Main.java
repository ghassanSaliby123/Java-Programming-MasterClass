package ghassan;

import java.util.Random;
import java.util.function.Supplier;

public class Main {

    //Through this example we start discussing the functional interfaces which are
    //the interfaces that have one method needs to be implemented
    //(it might have other methods, but it should have implementation, and it should be declared as default)
    //The Supplier interface is a functional one. It has 1 function get()
    //The test method tends to return a value without getting any arguments
    public static void main(String[] args) {
        //Using the get method in Supplier to get 10 random integers
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(supplier.get());
        }
//        Employee employee1 = new Employee("Ghassan", 30);
//        Employee employee2 = new Employee("Fadi", 35);
//        Employee employee3 = new Employee("Nanar", 30);
//        Employee employee4 = new Employee("Rita", 23);
//        Employee employee5 = new Employee("Melad", 25);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
//        employees.add(employee4);
//        employees.add(employee5);
//        //Print the employees names by the age condition
//        printEmployeeByAge(employees,"Employees over 30:",
//                employee -> employee.getAge() > 30);
//        System.out.println("-----------------------------------");
//        printEmployeeByAge(employees,"Employees under 30:",
//                employee -> employee.getAge() <= 30);
//        System.out.println("=====================================" );
//        //Apply several conditions and apply them with and() method in the Predicate interface
//        System.out.println("Applying several conditions and combine them with and() method");
//        IntPredicate lessThan20 = i -> i < 20;
//        IntPredicate greaterThan3 = i -> i >= 3;
//        System.out.println(lessThan20.and(greaterThan3).test(50));
//        System.out.println(greaterThan3.and(lessThan20).test(14));


    }

//    private static void printEmployeeByAge(List<Employee> employees,
//                                           String text,Predicate<Employee> ageCondition){
//        System.out.println(text);
//        for (Employee employee : employees) {
//            if (ageCondition.test(employee)){
//                System.out.println(employee.getName());
//            }
//        }
//
//    }
}



