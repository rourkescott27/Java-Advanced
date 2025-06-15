package practice8_1;

import java.util.List;
import java.util.function.Predicate;

/**
 * This class demonstrates using Java 8 streams and predicates to filter employees
 * and perform operations on the filtered results.
 */
public class RoboMailTest01 {

    public static void main ( String[] args ) {
        // Create a list of sample employees
        List<Employee> pl = Employee.createShortList();

        // Create an instance of RoboMail01 to send messages
        RoboMail01 robo = new RoboMail01();

        // Define predicates (conditions) for filtering employees

        // This predicate matches employees who are executives in the Sales department
        Predicate<Employee> salesExecutives =
                p -> p.getRole().equals(Role.EXECUTIVE)
                        && p.getDept().equals("Sales");

        // This predicate matches employees who are 50 or older and in the Sales department
        Predicate<Employee> salesEmployeesOver50 =
                p -> p.getAge() >= 50 && p.getDept().equals("Sales");

        System.out.println("\n==== RoboMail 01");
        System.out.println("\n=== Sales Execs ===");

        // Using stream to process the list of employees:
        // 1. Convert the list to a stream
        // 2. Filter to keep only sales executives
        // 3. For each remaining employee, send an email
        pl.stream()
                .filter(salesExecutives)
                .forEach(robo::roboMail);

        // Same as above, but sending text messages instead of emails
        pl.stream()
                .filter(salesExecutives)
                .forEach(robo::roboText);

        System.out.println("\n=== All Sales ===");

        // Filter for sales employees over 50 and send emails
        pl.stream()
                .filter(salesEmployeesOver50)
                .forEach(robo::roboMail);

        // Filter for sales employees over 50 and send texts
        pl.stream()
                .filter(salesEmployeesOver50)
                .forEach(robo::roboText);
    }
}