package domain;

// Employee class represents basic information and behavior of an employee
public class Employee {

    // Instance variables (fields) to store employee details
    public int empId;       // Employee ID
    public String name;     // Employee name
    public String ssn;      // Social Security Number
    public double salary;   // Salary

    // Default constructor (no arguments)
    public Employee () {
        // Initializes an empty employee object
    }

    public int getEmpId () {
        return empId;
    }

    public void setEmpId ( int empId ) {
        this.empId = empId;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getSsn () {
        return ssn;
    }

    public void setSsn ( String ssn ) {
        this.ssn = ssn;
    }

    public double getSalary () {
        return salary;
    }

    public void setSalary ( double salary ) {
        this.salary = salary;
    }

}
