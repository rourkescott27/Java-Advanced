package domain;

import java.text.NumberFormat;

public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee ( int empId, String name, String ssn, double salary ) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public void raiseSalary ( double increase ) {
        if (increase > 0) {
            salary = salary += increase;
        }
    }

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

    public void setName ( String name ) {
        if (name != null && !name.equals("")) {
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
