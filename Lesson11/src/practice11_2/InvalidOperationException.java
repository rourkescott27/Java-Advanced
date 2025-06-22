package practice11_2;

// Custom exception class to handle invalid operations related to Employee management
public class InvalidOperationException extends Exception {

    // Default constructor, calls the superclass Exception default constructor
    public InvalidOperationException () {
        super();
    }

    // Constructor that accepts a custom error message
    public InvalidOperationException ( String message ) {
        super(message);
    }

    // Constructor that accepts a cause (another throwable) for this exception
    public InvalidOperationException ( Throwable cause ) {
        super(cause);
    }

    // Constructor that accepts both a custom message and a cause
    public InvalidOperationException ( String message, Throwable cause ) {
        super(message, cause);
    }
}
