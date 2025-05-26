package exercise12_1;

import org.w3c.dom.ls.LSOutput;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.Month.*;  // Months
import static java.time.DayOfWeek.*; // Days of the week
import static java.time.temporal.ChronoUnit.*;  // DAYS, HOURS, etc

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDatesAndTimes {
    public static void main ( String[] args ) {
        //   Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
        //   How old when he died?
        System.out.println("---ABRAHAM LINCOLN---");
        LocalDate birthAL = LocalDate.of(1809,02,12);
        LocalDate deathAL = LocalDate.of(1855,04, 15 );
        long ageAL = birthAL.until(deathAL, YEARS);
        System.out.println("Abe Lincoln was " + ageAL + " years old when he died.");

        //   How many days did he live?
        long ageInDays = birthAL.until(deathAL, DAYS);
        System.out.println("Abe Lincoln was " + ageInDays + " days old when he passed." + "\n");

        //------------------------------------------------------//
        //   Bennedict Cumberbatch, July 19, 1976
        System.out.println("---BENNEDICT CUMBERBATCH---");

        //   Born in a leap year?
        LocalDate bornInLeapYear = LocalDate.of(1976,07,19);
        boolean leapYear = bornInLeapYear.isLeapYear();
        System.out.println("Was Bennedict Cumberbatch born in a leap year - " + leapYear);

        //   How many days in the year he was born?
        int totalDays = bornInLeapYear.lengthOfYear();
        System.out.println("There was " + totalDays + " days in the year Bennedict Cumberbatch was born!");

        //   How many decades old is he?
        LocalDate currentDate = LocalDate.now();
        long ageBC = bornInLeapYear.until(currentDate, DECADES);
        System.out.println("Bennedict Cumberbatch is " + ageBC + " decades old.");

        //   What was the day of the week on his 21st birthday?
        LocalDate twentyFirst = bornInLeapYear.plusYears(21);
        DayOfWeek dayOfTwentyFirst = twentyFirst.getDayOfWeek();
        System.out.println("He was born on a " + dayOfTwentyFirst + "\n");

        //------------------------------------------------------------------//

        // Train departs Boston at 1:45PM and arrives New York 7:25PM
        System.out.println("---TRAIN FROM BOSTON TO NEW YORK---");
        //   How many minutes long is the train ride?
        LocalTime departure = LocalTime.of(13, 45);
        LocalTime arrival = LocalTime.of(19,25 );
        long timeTraveled = departure.until(arrival, MINUTES);
        System.out.println("This train ride from Boston to New York takes " + timeTraveled + " minutes!");

        //   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
        LocalTime delay = arrival.plusHours(1).plusMinutes(19);
        System.out.println("The delayed train will arrive at " + delay + "PM\n");


        // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
        System.out.println("---FLIGHT FROM BOSTON TO MIAMI---");
        //   When does it arrive in Miami?
        LocalDateTime departureBo = LocalDateTime.of(2014, MARCH, 24, 21, 15);
        LocalDateTime arrivalMi = departureBo.plusHours(4).plusMinutes(15);
        System.out.println("The flight arrives in Miami at " + arrivalMi + "PM");
        //   When does it arrive if the flight is delayed 4 hours 27 minutes?
        LocalDateTime delayedMi = arrivalMi.plusHours(4).plusMinutes(27);
        System.out.println("The delayed flight arrives in Miami at " + delayedMi + "PM\n");

        // School semester starts the second Tuesday of September of this year (2014).
        System.out.println("---SCHOOL SEMESTER---");
        //   Hint: Look at the TemporalAdjusters class
        //   What is the date?
        LocalDate initialDate = LocalDate.of(2014, SEPTEMBER, 1);
        TemporalAdjuster secondTuesday = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY);
        LocalDate schoolStart = initialDate.with(secondTuesday);
        System.out.println("Date of school start is " + schoolStart + "\n");


        //   School summer vacation starts June 25th
        System.out.println("--- SCHOOL YEAR DURATION ---");
        //   Assuming:
        //     *  Two weeks off in December
        //     *  Two other vacation weeks
        //     *  School is taught Monday - Friday
        //   How many days of school are there?
        //   Hint: keep track of the short weeks also
        int excludeWeeks = 5;
        LocalDate schoolStarts = LocalDate.of(2014, SEPTEMBER, 1)
                .with(TemporalAdjusters.firstInMonth(TUESDAY)).with(TemporalAdjusters.next(TUESDAY));
        LocalDate endOfFirstWeek = schoolStarts.with(TemporalAdjusters.next(FRIDAY));
        long firstWeekDays = schoolStarts.until(endOfFirstWeek, DAYS) + 1;
        System.out.println("School Starts: " + schoolStarts);
        LocalDate schoolEnds = LocalDate.of(2015, JUNE, 25);
        System.out.println("School Ends: " + schoolEnds);

        long lastWeeksDays = 0;
        if(schoolEnds.getDayOfWeek() != MONDAY){
            LocalDate lastWeekStart = schoolEnds.with(TemporalAdjusters.previous(MONDAY));
            lastWeeksDays = lastWeekStart.until(schoolEnds, DAYS) + 1;
            excludeWeeks++;
        }
        long days = ((schoolStarts.until(schoolEnds, WEEKS) - excludeWeeks) * 5);
        days = days + firstWeekDays + lastWeeksDays;
        System.out.println("Number of school days: " + days + "\n");


        // A meeting is scheduled for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
        //   What is the time of the week's meetings?
        System.out.println("--- MEETING ---");
        LocalTime meetingTime = LocalTime.of(13, 30);
        LocalDate meetingDate = LocalDate.now().with(TemporalAdjusters.nextOrSame(TUESDAY));
        LocalDateTime meeting = LocalDateTime.of(meetingDate, meetingTime);
        System.out.println("This weeks meeting time is: " + meeting + "\n");

    }
}
