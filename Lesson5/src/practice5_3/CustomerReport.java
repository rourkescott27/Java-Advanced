package practice5_3;

// Generates a textual report of all customers and their accounts
public class CustomerReport {

    private Bank bank;

    public Bank getBank () {
        return bank;
    }

    public void setBank ( Bank bank ) {
        this.bank = bank;
    }

    // Prints a report listing all customers and their account balances
    public void generateReport () {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // Loop through each customer in the bank
        for (int custIndex = 0; custIndex < bank.getNumOfCustomers(); custIndex++) {
            Customer customer = bank.getCustomer(custIndex);

            // Print customer name and branch
            System.out.println();
            System.out.println("Customer: "
                                       + customer.getLastName() + ", "
                                       + customer.getFirstName()
                                       + "\nBranch: " + customer.getBranch() + ", "
                                       + customer.getBranch().getServiceLevel());

            // Loop through and print each of their accounts
            for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
                Account account = customer.getAccount(acctIndex);
                System.out.println("    " + account);  // uses Account's toString()
            }
        }
    }
}

