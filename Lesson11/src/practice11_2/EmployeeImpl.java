package practice11_2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl {

    // Array to store Employee objects (fixed size of 10)
    // Note: This is not thread-safe, so not safe for concurrent access
    private static Employee[] employeeArray = new Employee[10];

    // Package-level constructor - only accessible within the same package
    EmployeeImpl () {
    }

    // Add an Employee to the array
    public void add ( Employee emp ) throws InvalidOperationException {
        // Check if the employee ID already exists in the array
        if (employeeArray[emp.getId()] != null) {
            throw new InvalidOperationException("Error adding employee, employee id already exists " + emp.getId());
        }
        try {
            // Add employee to the array at index equal to employee's ID
            employeeArray[emp.getId()] = emp;
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle case when employee ID is outside the array bounds
            throw new InvalidOperationException("Error adding employee, id must be less than " + employeeArray.length);
        }
    }

    // Delete an Employee by their ID
    public void delete ( int id ) throws InvalidOperationException {
        // Check if an employee exists at the given ID
        if (employeeArray[id] == null) {
            throw new InvalidOperationException("Error deleting employee, no such employee " + id);
        }
        try {
            // Remove the employee by setting the slot to null
            employeeArray[id] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid ID outside array range
            throw new InvalidOperationException("Error deleting employee, id must be less than " + employeeArray.length);
        }
    }

    // Find and return an Employee by their ID
    public Employee findById ( int id ) throws InvalidOperationException {
        try {
            // Return the employee at the given index (may return null if not found)
            return employeeArray[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid ID outside array range
            throw new InvalidOperationException("Error finding employee ", e);
        }
    }

    // Get all existing employees as an array
    public Employee[] getAllEmployees () {
        List<Employee> emps = new ArrayList<>(); // Temporary list to collect employees
        // Loop through the employee array and add non-null entries to the list
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        // Convert the list back to an array and return it
        return emps.toArray(new Employee[0]);
    }
}
