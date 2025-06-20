package practice14_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class DirFind {

    public static void main ( String[] args ) {

        // Finds all directories up to 9 levels deep from current directory
        // isDirectory() checks if current path is a directory
        // Files.find returns a Stream<Path> that matches the given predicate
        try (Stream<Path> files = Files.find(Paths.get("."), 9, ( p, a ) -> a.isDirectory())) {
            System.out.println("\n=== Find all dirs ===");
            // Print out directory list here
            files.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
