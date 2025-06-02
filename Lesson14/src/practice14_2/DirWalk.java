package practice14_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author oracle
 */
public class DirWalk {
  public static void main(String[] args) {  

    /* Recursively(searches all subfolders in directory) walks through all directories and files starting form the
       current directory */
    try(Stream<Path> files = Files.walk(Paths.get("."))) {

        System.out.println("\n=== Dir walk ===");
        // Print directory list here
        files.forEach(line -> System.out.println(line));

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

    // Recursively searching for all folders containing "build"
    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");

        files
            .filter(path -> path.toString().contains("out")) // Using out as an example as I have no build files yet
            .forEach(line -> System.out.println(line));  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
