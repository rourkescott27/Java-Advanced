package practice4_1.domain;

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

    public String toString() {
        return  "Employee ID: " + getEmpId() + "\n" +
                "Employee Name: " + getName() + "\n" +
                "Employee SSN: " + getSsn() + "\n" +
                "Employee Salary: " + NumberFormat.getCurrencyInstance().format(getSalary());
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
