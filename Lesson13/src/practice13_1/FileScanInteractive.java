package practice13_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanInteractive {
    public int countTokens ( String file, String search ) throws IOException {
        int instanceCount = 0;
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                if (search.equalsIgnoreCase(s.next().trim())) {
                    instanceCount++;
                }
            }
        } // try-with-resources will close the connections
        return instanceCount;
    }

    public static void main ( String[] args ) {
        // Your code goes here
        // Prints a message if there is less than one argument
        if (args.length < 1) {
            System.out.println("Usage: java FileScanInteractive <file to search>");
            System.exit(-1);
        }
        // Saving the first argument
        String file = args[0];

        // Creating an instance of the ScanFileInteractive class
        FileScanInteractive scan = new FileScanInteractive();
        // Reading input
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String search = "";
            System.out.println("Searching through the file: " + file);
            while (true) {
                System.out.println("Enter the search string or q to exit: ");
                search = in.readLine().trim();
                if (search.equalsIgnoreCase("q")) {
                    break;
                }
                int count = scan.countTokens(file, search);
                System.out.println("The word \"" + search + "\" appears " + count + " times in the file.");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
            System.exit(-1);
        }
    }
}
