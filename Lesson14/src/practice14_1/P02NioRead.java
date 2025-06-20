package practice14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {

    public static void main ( String[] args ) {

      // More modern and concise than BufferedReader
        try {
            Stream<String> lines = Files.lines(Paths.get("hamlet.txt"));

            System.out.println("\n=== Entire File ===");
            lines.forEach(line -> System.out.println(line));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
