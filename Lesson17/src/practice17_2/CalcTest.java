package practice17_2;

import java.util.List;

public class CalcTest {

    public static void main ( String[] args ) {

        // Create a list of SalesTxn objects (each representing a sales transaction)
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // === Transactions Totals ===
        System.out.println("=== Transactions Totals ===");

        // Use a parallel stream to process transactions from "Radio Hut"
        // This allows multiple threads to process the data simultaneously
        double t1 = tList.parallelStream()
                .filter(t -> t.getBuyerName().equals("Radio Hut"))   // Keep only "Radio Hut" sales
                .mapToDouble(t -> t.getTransactionTotal())          // Get the total amount from each
                .sum();                                                     // Add all the totals together

        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);

        // Use a regular (sequential) stream and then switch to parallel after filtering
        // Still processes in parallel from the map step onward
        double t2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))    // Keep only "PriceCo" sales
                .mapToDouble(t -> t.getTransactionTotal())          // Extract the transaction totals
                .parallel()                                                  // Switch to parallel processing here
                .sum();                                                      // Sum all transaction totals

        System.out.printf("PriceCo Total: $%,9.2f%n", t2);

        // Use a stream that explicitly processes sequentially (single-threaded)
        double t3 = tList.stream()
                .filter(t -> t.getBuyerName().equals("Best Deals")) // Keep only "Best Deals" sales
                .mapToDouble(t -> t.getTransactionTotal())          // Extract the transaction totals
                .sequential()                                                // Ensure processing happens one step at a time
                .sum();                                                      // Sum all transaction totals

        System.out.printf("Best Deals Total: $%,9.2f%n", t3);
    }
}
