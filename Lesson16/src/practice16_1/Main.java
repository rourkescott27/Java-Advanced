package practice16_1;

import java.util.concurrent.ForkJoinPool;

public class Main {

    // We use a lot of memory for this array
    // The VM options (Run > Edit Configurations > VM Options) should include: -Xmx1024m
    // This increases the maximum heap size to 1024 MB (1 GB) to prevent out-of-memory errors

    public static void main ( String[] args ) {

        // Create a very large array of integers (128 million elements)
        // Each int is 4 bytes, so total memory used = 128 * 4 = 512MB
        int[] data = new int[1024 * 1024 * 128];

        // -------------------------------------------------------------
        // Normally we would populate the array with random values here:
        // (this is commented out because it takes time and memory)
        //
        // for (int i = 0; i < data.length; i++) {
        //     data[i] = ThreadLocalRandom.current().nextInt(); // Fill with random ints
        // }
        // -------------------------------------------------------------

        // -------------------------------------------------------------
        // Also, here’s how you could find the max value in a normal (non-parallel) way:
        //
        // int max = Integer.MIN_VALUE;
        // for (int value : data) {
        //     if (value > max) {
        //         max = value;
        //     }
        // }
        // System.out.println("Max value found:" + max);
        //
        // But this is very slow for large arrays.
        // -------------------------------------------------------------

        // Create a ForkJoinPool, which is a special type of thread pool designed for parallel tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Step 1: Populate the large array with random values using a Fork/Join action
        // This parallelizes filling the array to speed things up
        // data.length / 16 is the threshold: when to stop splitting and do the work directly
        RandomArrayAction action = new RandomArrayAction(data, 0, data.length - 1, data.length / 16);
        pool.invoke(action);  // Starts the action in parallel and waits for it to finish

        // Step 2: Now that the array is filled, find the max value using a parallel task
        // Create a FindMaxTask which is a RecursiveTask that finds the max in a portion of the array
        FindMaxTask task = new FindMaxTask(data, 0, data.length - 1, data.length / 16);
        Integer result = pool.invoke(task); // Starts the task in parallel and returns the result

        // Step 3: Print the max value found in the array
        System.out.println("Max value found: " + result);
    }
}
