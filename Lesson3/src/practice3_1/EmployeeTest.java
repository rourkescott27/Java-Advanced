package practice3_1;

import domain.*;

public class EmployeeTest {
    public static void main ( String[] args ) {

        Engineer eng = new Engineer(27, "Rourke Scott", "012-34-5678", 120_345.27);
        Manager mng = new Manager(23, "Liam Carter", "054-12-2367", 109_501.36, "US Marketing");
        Admin adm = new Admin(21, "Ava Thompson", "108-23-6509", 75_002.34);
        Director dir = new Director(07, "Noah Ramirez", "099-45-2340", 120_567.36, "Global Marketing",1_000_000.00);

        eng.printEmployee();
        mng.printEmployee();
        adm.printEmployee();
        dir.printEmployee();

        System.out.println("\nTesting raiseSalary and setName methods on Manager: ");
        mng.setName("Joe Rogan");
        mng.raiseSalary(50_000.00);
        mng.printEmployee();


    }
}
