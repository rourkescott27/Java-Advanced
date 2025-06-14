package practice6_2;

/**
 * Interface for account-related operations.
 * Implementing classes must define how deposits, withdrawals, and descriptions work.
 */
public interface AccountOperations {

    /**
     * Returns the current balance of the account.
     */
    public double getBalance ();

    /**
     * Adds the given amount to the account balance.
     *
     * @param amount the amount to deposit
     */
    public void deposit ( double amount );

    /**
     * Withdraws the given amount from the account if allowed.
     * Implementing classes define the specific logic.
     *
     * @param amount the amount to withdraw
     * @return true if withdrawal is successful, false otherwise
     */
    public abstract boolean withdraw ( double amount );

    /**
     * Returns a string description of the account type.
     *
     * @return a human-readable account type name
     */
    public abstract String getDescription ();
}

