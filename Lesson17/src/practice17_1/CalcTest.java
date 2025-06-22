package practice17_1;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CalcTest {

    public static void main ( String[] args ) {

        // Create a list of sales transactions
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Print a header before showing totals
        System.out.println("=== Transactions Totals ===");

        // Step 1: Start with a stream of all transactions
        Stream<SalesTxn> s1 = tList.stream();

        // Step 2: Filter the stream to only include transactions where the buyer is "Radio Hut"
        Stream<SalesTxn> s2 = s1.filter(
                t -> t.getBuyerName().equals("Radio Hut"));

        // Step 3: Convert each SalesTxn into just its transaction total (as a double)
        DoubleStream s3 = s2.mapToDouble(
                t -> t.getTransactionTotal());

        // Step 4: Sum all the transaction totals to get the total sales for "Radio Hut"
        double t1 = s3.sum();

        // Step 5: Print out the result in a formatted way (with dollar sign and commas)
        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);
    }
}
