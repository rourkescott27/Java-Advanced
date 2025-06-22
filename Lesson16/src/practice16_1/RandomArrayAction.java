package practice16_1;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

// This class fills part of an integer array with random values using parallelism.
// It extends RecursiveAction because it performs work (filling values) but doesn’t return a result.
public class RandomArrayAction extends RecursiveAction {

    private final int threshold;    // The cutoff size for when to stop splitting tasks
    private final int[] myArray;    // The array to fill with random numbers
    private int start;              // The start index for this task’s segment of the array
    private int end;                // The end index for this task’s segment of the array

    // Constructor to set up the task with its portion of the array and splitting threshold
    public RandomArrayAction ( int[] myArray, int start, int end, int threshold ) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    // This method is called automatically when the task is executed by a ForkJoinPool
    @Override
    protected void compute () {
        // If the section is small enough, fill it directly (base case)
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                // Generate a random integer for each index using a thread-safe random generator
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            // Otherwise, split the section into two subtasks (recursive case)
            int midway = (end - start) / 2 + start;

            // Create two smaller tasks for each half of the range
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, threshold);

            // Invoke both subtasks in parallel
            invokeAll(r1, r2);
        }
    }
}
