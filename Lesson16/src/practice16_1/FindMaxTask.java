package practice16_1;

import java.util.concurrent.RecursiveTask;

// This class extends RecursiveTask to find the maximum value in an array using the Fork/Join framework
public class FindMaxTask extends RecursiveTask<Integer> {

    private final int threshold;   // Threshold to decide when to stop splitting tasks
    private final int[] myArray;   // The array in which to find the maximum value
    private int start;             // Start index of the current sub-array
    private int end;               // End index of the current sub-array

    // Constructor initializes the task with the array, start and end indices, and threshold
    public FindMaxTask ( int[] myArray, int start, int end, int threshold ) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    // This method is called when the task is executed
    @Override
    protected Integer compute () {
        // If the sub-array size is smaller than the threshold, do the computation directly
        if (end - start < threshold) {
            int max = Integer.MIN_VALUE;  // Start with the smallest possible integer
            // Loop through the sub-array and find the maximum value
            for (int i = start; i <= end; i++) {
                int n = myArray[i];
                if (n > max) {
                    max = n;  // Update max if current number is larger
                }
            }
            return max;  // Return the maximum found in this sub-array
        } else {
            // If the sub-array is large, split it into two smaller tasks
            int midway = (end - start) / 2 + start;  // Find the midpoint index

            // Create a new task for the first half of the sub-array
            FindMaxTask a1 = new FindMaxTask(myArray, start, midway, threshold);
            a1.fork();  // Fork (start) the first task asynchronously

            // Create and compute the second half of the sub-array directly (without forking)
            FindMaxTask a2 = new FindMaxTask(myArray, midway + 1, end, threshold);

            // Compute the second half and wait for the first half to complete (join)
            // Then return the maximum of the two results
            return Math.max(a2.compute(), a1.join());
        }
    }
}
