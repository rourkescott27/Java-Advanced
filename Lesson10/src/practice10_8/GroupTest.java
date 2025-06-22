package practice10_8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupTest {

    public static void main ( String[] args ) {

        // Create a list of sales transactions
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Declare a map to hold the grouped transactions by buyer name
        Map<String, List<SalesTxn>> tMap;

        // === Group Transactions by Buyer ===
        System.out.println("=== Transactions Grouped by Buyer ===");

        // Use a stream to:
        // - Group transactions into a map where the key is the buyer's name
        // - The value is a list of transactions for that buyer
        tMap = tList.stream()
                .collect(Collectors.groupingBy(SalesTxn::getBuyerName));

        // Loop through each entry in the map
        // - k is the buyer's name
        // - v is the list of transactions for that buyer
        tMap.forEach(( k, v ) -> {
            System.out.println("\nBuyer: " + k); // Print the buyer name
            v.forEach(SalesTxn::printSummary);   // Print a summary of each transaction for that buyer
        });
    }
}
