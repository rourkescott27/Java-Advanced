package practice9_4;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main ( String[] args ) {

        // Create a list of sample Employee objects
        List<Employee> eList = Employee.createShortList();

        // Get the first employee in the list (not used for BiPredicate test in this example)
        Employee first = eList.get(0);

        // Define the state we want to search for
        String searchState = "KS";

        // Create a BiPredicate lambda that checks if an Employee's state matches the given state
        // BiPredicate takes two arguments (Employee and String) and returns a boolean
        BiPredicate<Employee, String> eBiPred =
                ( e, s ) -> e.getState().equals(s);

        System.out.println("=== Print matching list");

        // Loop through the employee list
        for (Employee e : eList) {
            // Use the BiPredicate to test if the employee's state matches searchState
            if (eBiPred.test(e, searchState)) {
                // If match found, print a summary of the employee
                e.printSummary();
            }
        }
    }
}

