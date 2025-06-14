package practice6_2;

public class AbstractBankingMain {

    public static void main ( String[] args ) {
        BankOperations bank = new Bank();
        initializeCustomers(bank);

        // Create a customer report and display account details
        bank.generateReport();
    }

    // Helper method to add predefined customers and their accounts to the bank
    private static void initializeCustomers ( BankOperations bank ) {
        Customer customer;

        // Customer 1: Will Smith - has a savings account
        bank.addCustomer("Will", "Smith", Branch.DURBAN);
        customer = bank.getCustomer(0);
        customer.addAccount(new SavingsAccount(800.00));

        // Customer 2: Bradley Cooper - savings account with extra deposit
        bank.addCustomer("Bradley", "Cooper", Branch.JOHANNESBURG);
        customer = bank.getCustomer(1);
        SavingsAccount sack = new SavingsAccount(560.00);
        customer.addAccount(sack);
        sack.deposit(500);  // triggers interest calculation

        // Customer 3: Rourke Scott - basic savings account
        bank.addCustomer("Rourke", "Scott", Branch.CAPE_TOWN);
        customer = bank.getCustomer(2);
        customer.addAccount(new SavingsAccount(500.00));

        // Customer 4: Naruto Uzumaki - checking account with overdraft
        bank.addCustomer("Naruto", "Uzumaki", Branch.PORT_ELIZABETH);
        customer = bank.getCustomer(3);
        customer.addAccount(new CheckingAccount(500.00, 600.00));

        // Customer 5: Brandon Smith - another checking account
        bank.addCustomer("Brandon", "Smith", Branch.DURBAN);
        customer = bank.getCustomer(4);
        customer.addAccount(new CheckingAccount(370.00, 700.00));

        // Customer 6: Jc Taljard - checking account
        bank.addCustomer("Jc", "Taljard", Branch.JOHANNESBURG);
        customer = bank.getCustomer(5);
        customer.addAccount(new CheckingAccount(500.00, 800.00));

        // Customer 7: Henrique de Lange - tries a large withdrawal
        bank.addCustomer("Henrique", "de Lange", Branch.JOHANNESBURG);
        customer = bank.getCustomer(6);
        CheckingAccount chkAcct = new CheckingAccount(500.00);
        customer.addAccount(chkAcct);

        // Try to withdraw beyond balance (no overdraft set)
        if (chkAcct.withdraw(900.00)) {
            customer.addAccount(chkAcct);
            System.out.print(" withdrawal is successful" + chkAcct.getBalance());
        }
    }
}
