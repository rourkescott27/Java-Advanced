package practice6_2;

// Represents a checking account with optional overdraft limit
public class CheckingAccount extends Account implements AccountOperations {

    private final double overDraftLimit;

    // Constructor with overdraft limit
    public CheckingAccount ( double balance, double overDraftLimit ) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    // Constructor with no overdraft
    public CheckingAccount ( double balance ) {
        this(balance, 0);
    }

    // Label for account type
    @Override
    public String getDescription () {
        return "Checking Account";
    }

    @Override
    public double getBalance () {
        return balance;
    }

    @Override
    public void deposit (double amount) {
        balance += amount;
    }

    @Override
    public String toString(){
        return this.getDescription() + "balance is: " + balance;
    }

    // Withdraw funds; allow overdraft if within limit
    @Override
    public boolean withdraw ( double amount ) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

