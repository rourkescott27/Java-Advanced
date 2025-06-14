package practice4_1;

import practice4_1.business.EmployeeStockPlan;
import practice4_1.domain.*;

// This code builds on previous examples involving the Employee superclass and its subclasses
// (Engineer, Manager, Admin, Director). The structure and behavior of those classes is already
// well-documented and will not be repeated here to avoid redundancy.

// The key addition in this version is the use of the EmployeeStockPlan class, which assigns
// different stock option values depending on the employee type using inheritance and instanceof.

// Demonstrates polymorphism and type-based logic using EmployeeStockPlan
public class EmployeeTest {
    public static void main ( String[] args ) {

        // Create various Employee objects from different subclasses
        Engineer eng = new Engineer(27, "Rourke Scott", "012-34-5678", 120_345.27);
        Manager mng = new Manager(23, "Liam Carter", "054-12-2367", 109_501.36, "US Marketing");
        Admin adm = new Admin(21, "Ava Thompson", "108-23-6509", 75_002.34);
        Director dir = new Director(07, "Noah Ramirez", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);

        // Instantiate the new class responsible for calculating stock options
        EmployeeStockPlan esp = new EmployeeStockPlan();

        // Print each employee’s details along with their stock options
        printEmployee(eng, esp);
        printEmployee(adm, esp);
        printEmployee(mng, esp);
        printEmployee(dir, esp);

        // Demonstrate reuse of inherited methods and effect of salary/name updates
        System.out.println("\nTesting raiseSalary and setName methods on Manager: ");
        mng.setName("Joe Rogan");
        mng.raiseSalary(50_000.00);
        printEmployee(mng, esp);
    }

    // Prints basic employee details using dynamic type information
    public static void printEmployee ( Employee emp ) {
        System.out.println("Employee type: " + emp.getClass().getSimpleName());
        System.out.println(emp);  // Relies on the toString() method (assumed overridden)
    }

    // Prints employee info along with stock options based on their role
    public static void printEmployee ( Employee emp, EmployeeStockPlan esp ) {
        printEmployee(emp);
        System.out.println("Stock Options: " + esp.grantStock(emp) + "\n");
    }
}
