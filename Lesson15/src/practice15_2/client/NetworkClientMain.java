package practice15_2.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class NetworkClientMain {

    public static void main ( String[] args ) {
        // The commented-out code shows a simple single-threaded approach to connect to servers

        // Create a thread pool to manage multiple client tasks concurrently
        ExecutorService es = Executors.newCachedThreadPool();

        // Map to link each RequestResponse with its Future result from the Callable task
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();

        String host = "localhost";

        // Loop to create and submit client connection tasks for ports 10000 to 10009
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            NetworkClientCallable callable = new NetworkClientCallable(lookup);

            // Submit the callable to the thread pool and store the Future in the map
            Future<RequestResponse> future = es.submit(callable);
            callables.put(lookup, future);
        }

        // Tell the executor to stop accepting new tasks
        es.shutdown();

        try {
            // Wait up to 5 seconds for all tasks to complete
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Stopped waiting early");
        }

        // Loop through each request to get and print the response or handle errors
        for (RequestResponse lookup : callables.keySet()) {
            Future<RequestResponse> future = callables.get(lookup);
            try {
                // Get the result from the Future (blocks if not ready)
                lookup = future.get();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (ExecutionException | InterruptedException ex) {
                // If the task failed, print an error message for that host and port
                System.out.println("Error talking to " + lookup.host + ":" + lookup.port);
            }
        }
    }
}
