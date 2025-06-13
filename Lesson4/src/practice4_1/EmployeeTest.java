package practice4_1;

import domain.*;
import business.EmployeeStockPlan;

public class EmployeeTest {
    public static void main ( String[] args ) {

        Engineer eng = new Engineer(27, "Rourke Scott", "012-34-5678", 120_345.27);
        Manager mng = new Manager(23, "Liam Carter", "054-12-2367", 109_501.36, "US Marketing");
        Admin adm = new Admin(21, "Ava Thompson", "108-23-6509", 75_002.34);
        Director dir = new Director(07, "Noah Ramirez", "099-45-2340", 120_567.36, "Global Marketing",1_000_000.00);
        EmployeeStockPlan esp = new EmployeeStockPlan();

        printEmployee(eng, esp);
        printEmployee(adm, esp);
        printEmployee(mng, esp);
        printEmployee(dir, esp);

        System.out.println("\nTesting raiseSalary and setName methods on Manager: ");
        mng.setName("Joe Rogan");
        mng.raiseSalary(50_000.00);
        printEmployee(mng, esp);

    }

    public static void printEmployee(Employee emp){
        System.out.println("Employee type: " + emp.getClass().getSimpleName());
        System.out.println(emp);
    }

    public static void printEmployee(Employee emp, EmployeeStockPlan esp){
        printEmployee(emp);
        System.out.println("Stock Options: " + esp.grantStock(emp) + "\n");
    }
}
