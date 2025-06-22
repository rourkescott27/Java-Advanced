package practice15_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main ( String[] args ) {

        // Create an ExecutorService to manage threads
        // newCachedThreadPool() creates a thread pool that can grow as needed
        ExecutorService es = Executors.newCachedThreadPool();

        // Submit CountRunnable tasks to the executor
        // Each task will run in its own thread (if available)
        es.submit(new CountRunnable(20, "A"));  // Task for Thread A
        es.submit(new CountRunnable(20, "B"));  // Task for Thread B
        es.submit(new CountRunnable(20, "C"));  // Task for Thread C

        // Shut down the ExecutorService after tasks are submitted
        // This means no new tasks will be accepted
        es.shutdown();
    }
}
