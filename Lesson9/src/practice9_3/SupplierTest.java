package practice9_3;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main ( String[] args ) {

        // Create a sample list of Employee objects using the helper method
        List<Employee> eList = Employee.createShortList();

        // Get the first employee from the list (not used here, but could be for reference)
        Employee first = eList.get(0);

        // === Supplier Lambda ===
        // A Supplier is a functional interface that returns a value but takes no input.
        // Here we are creating a lambda expression that returns a new Employee object.
        // This lambda "supplies" a fresh Employee when called.
        Supplier<Employee> eSupp =
                () -> new Employee.Builder()   // Start building a new Employee object using the Builder pattern
                        .givenName("Jill")
                        .surName("Doe")
                        .age(26)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Sales")
                        .startDate(LocalDate.of(2012, 7, 14))
                        .salary(45000)
                        .email("jill.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build();               // Finish and return the Employee object

        // Print the current employee list BEFORE adding the new employee
        System.out.println("=== Print employee list before");
        eList.stream().forEach(Employee::printSummary);  // Use method reference to print each summary

        // Add a new employee to the list by calling eSupp.get(), which runs the lambda and returns a new Employee
        eList.add(eSupp.get());

        // Print the updated employee list AFTER adding the new employee
        System.out.println("\n=== Print employee list after");
        eList.stream().forEach(Employee::printSummary);  // Print all summaries again to show the new addition
    }
}
