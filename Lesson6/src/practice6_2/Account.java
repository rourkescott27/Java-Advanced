package practice6_2;

// Abstract base class representing a bank account
public abstract class Account {

    protected double balance;

    // Constructor to initialize balance
    public Account ( double balance ) {
        this.balance = balance;
    }

    // Used for printing account info
    @Override
    public String toString () {
        return " Current balance is: " + balance;
    }

}
