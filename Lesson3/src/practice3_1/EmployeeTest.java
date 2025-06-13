package practice3_1;

import domain.*;

public class EmployeeTest {
    public static void main ( String[] args ) {

        // Create various employee types using parameterized constructors
        Engineer eng = new Engineer(27, "Rourke Scott", "012-34-5678", 120_345.27);
        Manager mng = new Manager(23, "Liam Carter", "054-12-2367", 109_501.36, "US Marketing");
        Admin adm = new Admin(21, "Ava Thompson", "108-23-6509", 75_002.34);
        Director dir = new Director(07, "Noah Ramirez", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);

        // Print employee details using inherited or overridden printEmployee() methods
        eng.printEmployee();    // Engineer info
        mng.printEmployee();    // Manager info (likely includes department)
        adm.printEmployee();    // Admin info
        dir.printEmployee();    // Director info (should include department and budget)

        // Demonstrate behavior change using setter and custom method
        System.out.println("\nTesting raiseSalary and setName methods on Manager: ");
        mng.setName("Joe Rogan");           // Change name using setter
        mng.raiseSalary(50_000.00);         // Increase salary using inherited method
        mng.printEmployee();                // Print updated info
    }
}

