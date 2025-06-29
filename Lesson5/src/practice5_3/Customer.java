package practice5_3;

// Represents a bank customer who can have multiple accounts
public class Customer {

    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;
    private Branch branch;

    public Customer ( String f, String l, Branch b ) {
        firstName = f;
        lastName = l;
        // Can hold up to 10 accounts
        accounts = new Account[10];
        numberOfAccounts = 0;
        branch = b;
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

    public Branch getBranch () {
        return branch;
    }

    public void setBranch ( Branch branch ) {
        this.branch = branch;
    }
}
