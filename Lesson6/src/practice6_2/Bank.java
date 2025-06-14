package practice6_2;

// Represents the bank containing a list of customers
public class Bank implements BankOperations{

    private Customer[] customers;
    private int numberOfCustomers;

    public Bank () {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Adds a new customer to the bank
    public void addCustomer ( String f, String l, Branch b ) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l, b);
    }

    public int getNumOfCustomers () {
        return numberOfCustomers;
    }

    public Customer getCustomer ( int customerIndex ) {
        return customers[customerIndex];
    }
}
