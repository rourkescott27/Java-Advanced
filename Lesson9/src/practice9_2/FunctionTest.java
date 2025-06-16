package practice9_2;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class FunctionTest {

    public static void main ( String[] args ) {

        // Create a list of sample Employee objects
        List<Employee> eList = Employee.createShortList();

        // Get the first employee from the list
        Employee first = eList.get(0);

        // Create a lambda expression using ToDoubleFunction
        // This function takes an Employee and returns their bonus as a double
        // The bonus is calculated by multiplying salary with a role-based bonus multiplier
        ToDoubleFunction<Employee> eFunc = t -> t.getSalary() * Bonus.byRole(t.getRole());

        // Print the first employee's details
        System.out.println("=== First Employee Bonus");
        first.printSummary();  // Print a summary of the employee's info

        // Apply the function to calculate and print the bonus
        System.out.println("Bonus: " + eFunc.applyAsDouble(first));
    }
}
