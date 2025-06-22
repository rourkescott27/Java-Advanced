package practice11_2;

import java.text.NumberFormat;

public class Employee {

    // Fields to store employee details
    private int id;
    private String firstName;
    private String lastName;
    private float salary;

    // Default constructor - creates an empty Employee object
    public Employee () {
    }

    // Constructor to initialize all fields when creating a new Employee
    public Employee ( int id, String firstName, String lastName, float salary ) {
        this.id = id;                   // Set employee ID
        this.firstName = firstName;     // Set first name
        this.lastName = lastName;       // Set last name
        this.salary = salary;           // Set salary
    }

    // Getter method for employee ID
    public int getId () {
        return id;
    }

    // Getter method for first name
    public String getFirstName () {
        return firstName;
    }

    // Getter method for last name
    public String getLastName () {
        return lastName;
    }

    // Getter method for salary
    public float getSalary () {
        return salary;
    }

    // Override toString method to display employee information nicely formatted
    @Override
    public String toString () {
        return "Employee ID:   " + getId() + "\n" +
                "Employee Name: " + getFirstName() + " " + getLastName() + "\n" +
                // Format salary as currency (e.g., $50,000.00)
                "Salary:        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }
}
