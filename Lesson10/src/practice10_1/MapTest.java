package practice10_1;

import java.util.List;

/**
 * Class to test and demonstrate some operations on SalesTxn data,
 * especially using Java Streams for filtering and mapping.
 */
public class MapTest {

    public static void main ( String[] args ) {

        // Create a list of sample sales transactions
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Print a header to indicate the output section for CA Widget Pro sales tax
        System.out.println("=== Widget Pro Sales Tax in CA ===");

        // Stream through the list of transactions and perform the following steps:
        tList.stream()
                // Step 1: Filter transactions to include only those where the state is CA (California)
                .filter(t -> t.getState().equals(State.CA))

                // Step 2: Further filter the transactions to include only those with product "Widget Pro"
                .filter(t -> t.getProduct().equals("Widget Pro"))

                // Step 3: Map each filtered transaction to its sales tax amount
                // The tax amount is calculated as: transaction total * tax rate for that state
                .map(t -> t.getTransactionTotal() * TaxRate.byState(t.getState()))

                // Step 4: For each calculated tax amount, print it to the console
                .forEach(amt -> System.out.printf("Txn tax: $%,9.2f%n", amt));
        // Note: The format specifier here ("%9.2f") is included as text,
        // so it won't format the number properly in this usage.
        // To format numbers correctly, use String.format() or System.out.printf().
    }
}
