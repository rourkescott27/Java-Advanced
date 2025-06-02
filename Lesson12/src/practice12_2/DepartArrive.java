package practice12_2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import static java.time.Month.*;

public class DepartArrive {
    public static void main(String[] args) {
        // Using the following information:
        //   * Use America/New_York as the time zone for Boston Logan Airport(BOS).
        ZoneId BOS = ZoneId.of("America/New_York");
        //   * Use America/Los_Angeles as the time zone for San Francisco Airport (SFO).
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        //   * Use Asia/Calcutta as the time zone for Bangalore's Bengaluru International Airport (BLR)
        ZoneId BLR = ZoneId.of("Asia/Calcutta");


        // Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014
        // The flight is 5 hours 30 minutes
        System.out.println("--- San Francisco to Boston ---");
        //   What is the local time in Boston when the flight takes off?
        LocalDateTime departure = LocalDateTime.of(2014, JUNE, 13,22, 30);
        ZonedDateTime departureSFO = ZonedDateTime.of(departure, SFO);
        ZonedDateTime LocalTimeInBOS = departureSFO.toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Local time in Boston when the flight departs from San Fransisco: " + LocalTimeInBOS);

        //   What is the local time at Boston Logan airport when the flight arrives?.
        ZonedDateTime arrivalBOS = departureSFO.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Local time in Boston when the flight arrives from San Fransisco: " + arrivalBOS);

        //   What is the local time in San Francisco when the flight arrives?
        ZonedDateTime LocalTimeInSFO = arrivalBOS.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Local time in San Fransisco when the flight arrives in Boston: " + LocalTimeInSFO + "\n");

        //-----------------------------------------------------------------------------------------------//
        // Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
        System.out.println("--- San Fransisco to Bangalore ---");
        // The flight time is 22 hours
        LocalDateTime depart = LocalDateTime.of(2014, JUNE, 28,22, 30);
        ZonedDateTime departureTimeSFO = ZonedDateTime.of(depart, SFO);

        //   Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
        ZonedDateTime arrivalTimeBLR = departureTimeSFO.plusHours(22).toOffsetDateTime().atZoneSameInstant(BLR);
        System.out.println("The traveler's meeting is at 9AM and the flight arrives at : " + arrivalTimeBLR);

        //   Can the traveler call her husband at a reasonable time when she arrives?
        ZonedDateTime localTimeSFO = arrivalTimeBLR.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Local time in San Fransisco on arrival in Calcutta is " + localTimeSFO + " so a phone call would still be reasonable.\n");

        // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
        System.out.println("--- San Fransisco to Boston ---");
        // Flight time is 5 hours 30 minutes.
        LocalDateTime SFOtoBOS = LocalDateTime.of(2014, NOVEMBER, 01, 22,30);
        //   What day and time does the flight arrive in Boston?
        ZonedDateTime arrivalBOS2 = ZonedDateTime.of(SFOtoBOS, SFO);
        System.out.println("Local time on arrival in Boston is : "+ arrivalBOS2);
        //   What happened?
        //????
    }
}
