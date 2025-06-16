package practice8_4;

import java.util.List;

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
        System.out.println("\n === Male Engineering Employees Under 65");

        // Start of stream processing
        // Filtering for all male engineers under the age of 65
        pl.stream()
                .filter(p -> p.getGender().equals(Gender.MALE))
                .filter(p -> p.getAge() < 65)
                .filter(p -> p.getDept().equals("Eng"))
                .forEach(p -> robo.roboMail(p));

        // Note: The entire stream operation could be read as:
        // "For each employee who is a male engineer under the age of 65 , send a robo mail"
    }
}