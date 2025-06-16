package practice9_1;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main ( String[] args ) {

        // Create a list of employees using the static method from the Employee class
        List<Employee> eList = Employee.createShortList();

        // Get the first employee from the list
        Employee first = eList.get(0);

        // Create a Consumer that takes an Employee and prints their full name, role, and salary
        // A Consumer is a functional interface that takes one input and returns no result
        Consumer<Employee> eCons = e ->
                System.out.println("Full Name: " + e.getGivenName() + " " + e.getSurName() + "\n"
                                           + "Role: " + e.getRole() + "\n"
                                           + "Salary: " + e.getSalary());

        // Print a header to indicate the output that follows
        System.out.println("=== First Salary");

        // Use the Consumer to print information about the first employee
        // The accept() method runs the Consumer logic on the given Employee
        eCons.accept(first);
    }
}
