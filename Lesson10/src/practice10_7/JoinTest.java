package practice10_7;

import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {

    public static void main ( String[] args ) {

        // Create a list of SalesTxn objects (each representing a sales transaction)
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // === Print a Sorted List of Unique Buyer Names ===
        System.out.println("=== Sorted Buyer's List ===");

        // Use a stream to:
        // - Extract buyer names from transactions
        // - Remove duplicates using distinct()
        // - Sort the names alphabetically
        // - Join them into a single string, separated by commas
        String result = tList.stream()
                .map(t -> t.getBuyerName()) // Get buyer name from each transaction
                .distinct() // Eliminate duplicate buyer names
                .sorted() // Sort names in alphabetical order
                .collect(Collectors.joining(", ")); // Combine into one string with ", " between names

        // Print the final joined result
        System.out.println("Buyer list: " + result);
    }
}
