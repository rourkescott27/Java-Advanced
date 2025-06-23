package practice14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P03NioReadAll {

    public static void main(String[] args) {

        // This will hold all the lines read from the file as a list of strings
        List<String> fileArr;

        // Create a Path object pointing to the file "hamlet.txt"
        // This path is relative to the working directory when running the program
        Path file = Paths.get("hamlet.txt");

        try {
            // Read all lines from the file into the list 'fileArr'
            // Files.readAllLines reads the entire file at once and returns a List of lines
            fileArr = Files.readAllLines(file);

            // Print a header to mark where lines containing "Ros." will be shown
            System.out.println("\n=== Rosencrantz ===");

            // Use Java Streams to process each line in fileArr
            // Filter keeps only lines that contain "Ros."
            // forEach prints each matching line to the console
            fileArr.stream()
                    .filter(line -> line.contains("Ros."))
                    .forEach(System.out::println);

            // Print a header for the next filtered output
            System.out.println("\n=== Guildenstern ===");

            // Similarly, filter for lines containing "Guil." and print them
            fileArr.stream()
                    .filter(line -> line.contains("Guil."))
                    .forEach(System.out::println);

        } catch (IOException e) {
            // If an error occurs reading the file (e.g., file not found), print the error message
            System.out.println("Error: " + e.getMessage());
        }

    }
}
