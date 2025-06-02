package practice14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author oracle
 */
public class P03NioReadAll {

    public static void main ( String[] args ) {

        List<String> fileArr;
        Path file = Paths.get("hamlet.txt");

        try {
            // Read file into array here
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream()
                    .filter(line -> line.contains("Ros."))
                    .forEach(System.out::println);


            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            fileArr.stream()
                    .filter(line -> line.contains("Guil."))
                    .forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
