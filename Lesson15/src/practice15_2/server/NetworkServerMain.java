package practice15_2.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {

    public static void main ( String[] args ) {
        // Create an ExecutorService with a cached thread pool to run server threads
        ExecutorService exSrv = Executors.newCachedThreadPool();

        // List to hold the server Runnable instances
        List<Runnable> runners = new ArrayList<>();

        // Loop through ports 10000 to 10009 and create a PriceRangeServer on each port
        for (int port = 10000; port < 10010; port++) {
            Runnable r;
            try {
                // Create a new PriceRangeServer that listens on 'port' with price range 20 to 110
                r = new PriceRangeServer(port, 20, 110);
                runners.add(r); // Add the server to the list
            } catch (IOException ex) {
                // If port is already in use, print an error message and skip
                System.out.println("Port " + port + " already in use");
            }
        }

        // Execute each server Runnable in the thread pool to start listening concurrently
        for (Runnable r : runners) {
            exSrv.execute(r);
        }

        // Pause for a short moment (500 ms) before continuing
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            // Ignore interruption here
        }

        // Prompt user to press enter to quit the servers
        System.out.println("Press enter to quit...");
        try {
            System.in.read();  // Wait for user to press enter
        } catch (IOException ex) {
            // Ignore input exceptions
        }

        // Shutdown all running server threads immediately
        System.out.println("Quitting...");
        exSrv.shutdownNow();
    }
}
