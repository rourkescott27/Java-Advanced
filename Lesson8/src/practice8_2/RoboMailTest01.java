package practice8_2;

import java.util.List;
import java.util.function.Predicate;

/**
 * This class demonstrates using Java 8 streams and predicates to filter employees
 * and perform operations on the filtered results.
 * <p>
 * A stream in Java is like a pipeline that processes data in a sequence.
 * Predicates are conditions used to filter data.
 */
public class RoboMailTest01 {

    public static void main ( String[] args ) {
        // Create a list of sample employees
        // This calls a static method from the Employee class that returns a pre-populated list
        List<Employee> pl = Employee.createShortList();

        // Create an instance of RoboMail01 to send messages
        // This object will be used to send mail to filtered employees
        RoboMail01 robo = new RoboMail01();

        // Print headers to the console to show what we're doing
        System.out.println("\n ==== RoboMail 01");
        System.out.println("\n === Sales Executive");

        // Start of stream processing
        pl.stream()  // Convert the list to a stream for processing
                // First filter: Keep only employees with EXECUTIVE role
                // The p -> syntax is a lambda expression (a short way to write a function)
                // This reads as "for each employee p, check if their role equals EXECUTIVE"
                .filter(p -> p.getRole().equals(Role.EXECUTIVE))

                // Second filter: From the executives, keep only those in Sales department
                // This creates a chain of filters, so we only get Sales Executives
                .filter(p -> p.getDept().equals("Sales"))

                // For each filtered employee, call the roboMail method
                // forEach is a terminal operation that ends the stream and performs an action
                // This sends a mail to each Sales Executive in our filtered list
                .forEach(p -> robo.roboMail(p));

        // Note: The entire stream operation could be read as:
        // "For each employee who is an executive in the Sales department, send a robo mail"
    }
}