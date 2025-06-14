package practice6_2;

/**
 * Interface for banking system operations, including customer management
 * and report generation.
 */
public interface BankOperations {

    /**
     * Adds a new customer to the bank.
     *
     * @param f first name of the customer
     * @param l last name of the customer
     * @param b the branch the customer is assigned to
     */
    public void addCustomer ( String f, String l, Branch b );

    /**
     * Gets the total number of customers in the bank.
     *
     * @return number of customers
     */
    public int getNumOfCustomers ();

    /**
     * Retrieves the customer at a specific index.
     *
     * @param customerIndex the index of the customer
     * @return the Customer object
     */
    public Customer getCustomer ( int customerIndex );

    /**
     * Default method to generate a formatted report of all customers and their accounts.
     * This is implemented directly in the interface to provide a shared utility.
     */
    public default void generateReport () {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // Loop through each customer in the bank
        for (int custIndex = 0; custIndex < this.getNumOfCustomers(); custIndex++) {
            Customer customer = this.getCustomer(custIndex);

            // Print customer name and their branch info
            System.out.println();
            System.out.println("Customer: "
                                       + customer.getLastName() + ", "
                                       + customer.getFirstName()
                                       + "\nBranch: " + customer.getBranch() + ", "
                                       + customer.getBranch().getServiceLevel());

            // Loop through each of the customer's accounts
            for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
                AccountOperations account = customer.getAccount(acctIndex);
                System.out.println("    " + account); // account.toString() is used here
            }
        }
    }
}

