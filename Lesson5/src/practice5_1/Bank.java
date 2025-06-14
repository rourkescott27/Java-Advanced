package practice5_1;

// Represents the bank containing a list of customers
public class Bank {

    private Customer[] customers;
    private int numberOfCustomers;

    public Bank () {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Adds a new customer to the bank
    public void addCustomer ( String f, String l ) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    public int getNumOfCustomers () {
        return numberOfCustomers;
    }

    public Customer getCustomer ( int customerIndex ) {
        return customers[customerIndex];
    }
}
