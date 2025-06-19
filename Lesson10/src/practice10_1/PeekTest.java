package practice10_1;

import java.util.List;
import java.util.function.Consumer;

/**
 * Demonstrates the use of the Stream 'peek' method
 * to inspect elements during stream processing.
 */
public class PeekTest {

    public static void main ( String[] args ) {

        // Create a list of sample sales transactions
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define a Consumer to print a tax report line for each transaction
        // This prints transaction id, buyer name, and transaction amount formatted nicely
        Consumer<SalesTxn> taxReport = t ->
                System.out.printf("Id: " + t.getTxnId()
                                          + " Buyer: " + t.getBuyerName() +
                                          " Txn amt: $%,9.2f ", t.getTransactionTotal());

        // Print a header to indicate the report section
        System.out.println("=== Widget Pro Sales Tax in CA ===");

        // Stream through the list of transactions and perform the following:
        tList.stream()
                // Filter transactions to include only those from California (State.CA)
                .filter(t -> t.getState().equals(State.CA))

                // Filter further to only include transactions for product "Widget Pro"
                .filter(t -> t.getProduct().equals("Widget Pro"))

                // Use 'peek' to perform the taxReport action on each filtered transaction
                // 'peek' is often used for debugging or side effects without altering the stream
                .peek(taxReport)

                // Map each transaction to its calculated sales tax amount
                // Tax = transaction total * tax rate for the state
                .map(t -> t.getTransactionTotal() * TaxRate.byState(t.getState()))

                // For each tax amount, print it formatted with 2 decimals and commas
                .forEach(amt -> System.out.printf("Txn tax: $%,9.2f%n", amt));
    }
}
