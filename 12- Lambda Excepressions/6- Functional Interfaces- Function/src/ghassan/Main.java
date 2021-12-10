package ghassan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {

    //Through this example we start discussing the functional interfaces which are
    //the interfaces that have one method needs to be implemented
    //(it might have other methods, but it should have implementation, and it should be declared as default
    // or static)
    //The Function interface is a functional one. It has several functions with  default or static keywords
    // and it has the apply() method to be implemented
    //The apply method tends to get an argument and return
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ghassan Saliby", 30);
        Employee employee2 = new Employee("Fadi Saliby", 35);
        Employee employee3 = new Employee("Nanar Hawach", 30);
        Employee employee4 = new Employee("Rita Sliby", 23);
        Employee employee5 = new Employee("Melad Matni", 25);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Function<Employee, String> getLastName = employee -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        String lastName = getLastName.apply(employees.get(1));

        Function<Employee,String> getFirstName = employee -> {
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random random = new Random();
        for (Employee employee : employees) {
            if (random.nextBoolean()){
                System.out.println(getName(getFirstName, employee));
            }else {

            }
        }
    }

    private static String getName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }
}



