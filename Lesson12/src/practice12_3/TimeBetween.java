package practice12_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeBetween {
    public static void main(String[] args) {
        // Create a formatter to accept date entries using the USA common standard,
        // month day, year = for example, April 8, 1970
        String dateFormat = "MMMM d, yyyy";
        LocalDate aDate = null;

        boolean validStr = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Create a formatter
        while (!validStr) {
            System.out.print("Enter a date: ("+ dateFormat +"): ");
            try {
                String dateEntered = br.readLine();
                aDate = LocalDate.parse(dateEntered, formatter);
                // Use the parse method with the formatter to create a date
                validStr = true;
            } catch (IOException | DateTimeParseException ex) {
                validStr = false;
            }
        }

        // Print the date out
        System.out.println("Date entered was: " + aDate.format(formatter));
        LocalDate now = LocalDate.now();

        // Calculate the years, months and days between now and the date entered
        Period between;
        if(aDate.isBefore(now)) {
            between = Period.between(aDate, now);
        } else {
            between = Period.between(now, aDate);
        }

        // Print out the
        int years = between.getYears();
        int months = between.getMonths();
        int days = between.getDays();
        System.out.println("There are " + years + " years, "
                                   + months + " months, "
                                   + days + " days between now and the date entered.");
    }
}
