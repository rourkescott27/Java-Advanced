package practice10_3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RadioHutTest {

    public static void main ( String[] args ) {

        // Create a list of sales transactions using a factory method
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define a lambda expression (as a Consumer) to print transaction details in a formatted way
        Consumer<SalesTxn> radioReport =
                t -> System.out.printf("ID: " + t.getTxnId() +
                                               "  Seller: " + t.getSalesPerson() +
                                               " -- Buyer: " + t.getBuyerName() +
                                               " -- State: " + t.getState() +
                                               " -- Amt: $%,9.0f%n", t.getTransactionTotal());

        // Print out all transactions where the buyer is "Radio Hut"
        System.out.println("=== Radio Hut Transactions ===");
        tList.stream() // Start a stream of transactions
                .filter(t -> t.getBuyerName().equals("Radio Hut")) // Filter only those for "Radio Hut"
                .forEach(radioReport); // Print each matching transaction using the consumer

        // Print out the total number of transactions made by "Radio Hut"
        System.out.print("Total Transactions: ");
        long tCount = tList.stream()
                .filter(t -> t.getBuyerName().equals("Radio Hut"))
                .count(); // Count how many match the filter
        System.out.println(tCount);

        // Find and print the largest transaction by "Radio Hut"
        System.out.println("=== Radio Hut Largest ===");
        Optional<SalesTxn> tLarge = tList.stream()
                .filter(t -> t.getBuyerName().equals("Radio Hut")) // Only "Radio Hut" transactions
                .max(Comparator.comparing(SalesTxn::getTransactionTotal)); // Find the one with the highest total

        // If a largest transaction is found, print it
        if (tLarge.isPresent()) {
            radioReport.accept(tLarge.get());
        }

        // Find and print the smallest transaction by "Radio Hut"
        System.out.println("=== Radio Hut Smallest ===");
        Optional<SalesTxn> tSmall = tList.stream()
                .filter(t -> t.getBuyerName().equals("Radio Hut")) // Only "Radio Hut" transactions
                .min(Comparator.comparing(SalesTxn::getTransactionTotal)); // Find the one with the lowest total

        // If a smallest transaction is found, print it
        if (tSmall.isPresent()) {
            radioReport.accept(tSmall.get());
        }
    }
}
