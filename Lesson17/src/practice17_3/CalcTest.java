package practice17_3;

import java.util.List;

public class CalcTest {

    public static void main ( String[] args ) {

        // Create a list of SalesTxn objects (each representing a sales transaction)
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // === Transactions Totals ===
        System.out.println("=== Transactions Totals ===");

        // Calculate the total transaction amount for "PriceCo" using reduce and parallel stream
        double t2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))     // Filter only "PriceCo" transactions
                .mapToDouble(t -> t.getTransactionTotal())           // Extract the transaction amounts
                .parallel()                                                   // Use parallel processing
                .reduce(0, ( sum, e ) -> sum + e);      // Add them up using reduce

        System.out.printf("%nPriceCo Total: $%,9.2f%n", t2);

        // Count the number of "PriceCo" transactions using reduce
        int c2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))      // Same filtering step
                .mapToInt(t -> 1)                                     // Convert each transaction to 1 (for counting)
                .parallel()                                                    // Again use parallel processing
                .reduce(0, ( sum, e ) -> sum + e);              // Add up all the 1s to get the count

        System.out.printf("PriceCo Transactions: %,6d%n", c2);
    }
}
