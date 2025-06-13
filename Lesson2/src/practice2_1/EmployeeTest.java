package practice2_1;

import domain.Employee;

public class EmployeeTest {
    public static void main ( String[] args ) {

        // Create an Employee object using the default constructor
        Employee emp = new Employee();

        // Set the employee's information using setter methods
        emp.setEmpId(27);                            // Set employee ID
        emp.setName("Rourke Scott");                 // Set employee name
        emp.setSsn("012-34-5678");                   // Set employee SSN
        emp.setSalary(15000.00);                     // Set employee salary

        // Print employee information using getter methods
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee SSN: " + emp.getSsn());
        System.out.println("Employee Salary: " + emp.getSalary());
    }
}
