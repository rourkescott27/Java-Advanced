package practice5_1;

// Abstract base class representing a bank account
public abstract class Account {

    protected double balance;

    // Constructor to initialize balance
    public Account ( double balance ) {
        this.balance = balance;
    }

    public double getBalance () {
        return balance;
    }

    // Adds amount to balance
    public void deposit ( double amount ) {
        balance += amount;
    }

    // Used for printing account info
    @Override
    public String toString () {
        return getDescription() + ": current balance is " + balance;
    }

    // Abstract methods to be implemented by subclasses
    public abstract boolean withdraw ( double amount );

    public abstract String getDescription ();
}
