package domain;

import java.text.NumberFormat;

// The Employee class acts as a superclass for multiple subclasses in the domain package,
// allowing them to inherit shared attributes (like empId, name, ssn, salary) and methods.
public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    // This constructor initializes the common attributes shared across all subclasses.
// While constructors are not inherited, the fields (empId, name, ssn, salary) are inherited
// and can be initialized from the subclass using a call to super(...).
    public Employee ( int empId, String name, String ssn, double salary ) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    // This method increases the employee's salary by the specified amount.
    // It checks that the increase is positive to prevent accidental salary reduction.
    public void raiseSalary ( double increase ) {
        if (increase > 0) {
            salary = salary += increase;
        }
    }

    // This method prints the employee's details using the attributes initialized in the constructor.
    // The salary is formatted as currency for better readability.
    public void printEmployee () {
        System.out.println();
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("SSN #: " + ssn);
        System.out.println("Salary: " + NumberFormat.getCurrencyInstance().format((double) getSalary()));
    }

    public int getEmpId () {
        return empId;
    }

    public String getName () {
        return name;
    }

    // Sets the employee's name only if a non-null, non-empty string is provided.
    // Prevents assigning an invalid or blank name.
    // (name != null && !name.equals("")) -> changed this logic to ensure that a string with only spaces is also rejected.
    public void setName ( String name ) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getSsn () {
        return ssn;
    }

    public double getSalary () {
        return salary;
    }

}
