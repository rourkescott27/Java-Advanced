package practice13_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanInteractive {

    /**
     * This method counts how many times the search word appears in the given file.
     *
     * @param file   The path to the text file to search
     * @param search The word to count occurrences of
     * @return The number of times the search word appears in the file
     * @throws IOException If there is a problem reading the file
     */
    public int countTokens ( String file, String search ) throws IOException {
        int instanceCount = 0; // To keep track of how many times the word appears

        // Open the file using FileReader and wrap it in BufferedReader for efficient reading
        // Then wrap BufferedReader in Scanner to easily parse tokens (words)
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             Scanner s = new Scanner(br)) {

            // Set the delimiter to any non-word character (anything other than letters/digits)
            // This means Scanner will treat punctuation and spaces as separators
            s.useDelimiter("\\W");

            // Loop through all tokens (words) in the file
            while (s.hasNext()) {
                // Get the next token and trim whitespace
                String token = s.next().trim();

                // Check if this token matches the search word (case-insensitive)
                if (search.equalsIgnoreCase(token)) {
                    instanceCount++; // If yes, increase the count
                }
            }
        } // The try-with-resources automatically closes the file and scanner here

        return instanceCount; // Return the total count found
    }

    public static void main ( String[] args ) {
        // Check if the user has provided a filename as an argument
        if (args.length < 1) {
            System.out.println("Usage: java FileScanInteractive <file to search>");
            System.exit(-1); // Exit program with error code if no filename is provided
        }

        // Save the filename argument in a variable
        String file = args[0];

        // Create an instance of this class to call the countTokens method
        FileScanInteractive scan = new FileScanInteractive();

        // Create a BufferedReader to read user input from the keyboard (System.in)
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String search = "";

            System.out.println("Searching through the file: " + file);

            // Loop indefinitely to allow multiple searches until the user quits
            while (true) {
                System.out.println("Enter the search string or q to exit: ");

                // Read a line from the user, trim whitespace
                search = in.readLine().trim();

                // If user inputs 'q' or 'Q', break the loop and end the program
                if (search.equalsIgnoreCase("q")) {
                    break;
                }

                // Call the method to count how many times 'search' appears in the file
                int count = scan.countTokens(file, search);

                // Print the result to the console
                System.out.println("The word \"" + search + "\" appears " + count + " times in the file.");
            }
        } catch (IOException e) {
            // If any IOException occurs, print the exception and exit
            System.out.println("Exception: " + e);
            System.exit(-1);
        }
    }
}
