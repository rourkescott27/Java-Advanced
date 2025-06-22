package practice10_6;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectTest {

    public static void main ( String[] args ) {

        // Create a list of SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // This will hold the filtered and sorted transactions
        List<SalesTxn> rList;

        // === Filter and Print Transactions over $300,000 ===
        System.out.println("=== Transactions over $300k ===");

        // Use a stream to:
        // - Filter transactions greater than $300,000
        // - Sort them in ascending order by total amount
        // - Collect the results into a new list (rList)
        rList = tList.stream()
                .filter(t -> t.getTransactionTotal() > 300000) // Keep only high-value transactions
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal)) // Sort by total amount (ascending)
                .collect(Collectors.toList()); // Store results in a new list

        // Loop through and print each transaction in the result list
        rList.stream()
                .forEach(t -> System.out.printf(
                        "Id: " + t.getTxnId() +
                                " Seller: " + t.getSalesPerson() +
                                " Buyer: " + t.getBuyerName() +
                                " Amt: $%,9.2f%n", t.getTransactionTotal()
                ));
    }
}
