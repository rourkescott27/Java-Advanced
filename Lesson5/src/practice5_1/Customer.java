package practice5_1;

// Represents a bank customer who can have multiple accounts
public class Customer {

    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;

    public Customer ( String f, String l ) {
        firstName = f;
        lastName = l;
        // Can hold up to 10 accounts
        accounts = new Account[10];
        numberOfAccounts = 0;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    // Adds an account to the customer
    public void addAccount ( Account acct ) {
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    public int getNumOfAccounts () {
        return numberOfAccounts;
    }

    public Account getAccount ( int accountIndex ) {
        return accounts[accountIndex];
    }
}
