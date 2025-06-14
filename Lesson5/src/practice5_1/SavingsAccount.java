package practice5_1;

// Represents a savings account with interest
public class SavingsAccount extends Account {
    Double rateofinterest = 0.06;

    public SavingsAccount ( double balance ) {
        super(balance);
    }

    // Withdraw only if funds are sufficient (no overdraft allowed)
    @Override
    public boolean withdraw ( double amount ) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Deposit adds interest immediately after adding funds
    @Override
    public void deposit ( double amount ) {
        balance += amount;
        balance += balance * rateofinterest;
    }

    @Override
    public String getDescription () {
        return "Savings Account";  // Was checking account
    }
}

