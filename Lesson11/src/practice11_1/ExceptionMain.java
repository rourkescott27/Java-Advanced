package practice11_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {
    public static void main ( String[] args ) {

        // Try to read the first command-line argument (file name)
        try {
            System.out.println("Reading from file:" + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // If no argument was provided, print an error message and exit the program
            System.out.println("No file specified, quitting!");
            System.exit(1); // Exit with error code 1
        }

        // Try-with-resources: open the file and create a BufferedReader to read it
        try (BufferedReader b = new BufferedReader(new FileReader(args[0]));) {
            String s = null;

            // Read each line from the file until the end is reached
            while ((s = b.readLine()) != null) {
                System.out.println(s); // Print each line to the console
            }

            // Handle case where the file does not exist
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1); // Exit with error code 1

            // Handle any other I/O error while reading the file
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1); // Exit with error code 1
        }
    }
}
