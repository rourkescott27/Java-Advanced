package practice15_1;

// This class implements the Runnable interface so it can be run as a thread
public class CountRunnable implements Runnable {

    // Declare variables to store how high to count and the name of the thread
    final int count;
    final String threadName;

    // Constructor to initialize the 'count' and 'threadName' when an object is created
    public CountRunnable ( int count, String threadName ) {
        this.count = count;               // How many times to count
        this.threadName = threadName;     // Name to identify the thread
    }

    // The run() method is called when the thread starts
    public void run () {
        // A simple loop that counts from 1 up to 'count'
        for (int i = 1; i <= count; i++) {
            // Print the thread's name and the current number
            System.out.println("Thread " + threadName + ": " + i);
        }
    }
}
