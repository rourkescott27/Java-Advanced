package practice5_3;

// Represents a checking account with optional overdraft limit
public class CheckingAccount extends Account {

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

