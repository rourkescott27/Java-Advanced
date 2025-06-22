package practice10_5;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortTest {

    public static void main ( String[] args ) {

        // Create a list of SalesTxn objects using a factory method
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define a lambda expression (Consumer) to print details of each transaction
        Consumer<SalesTxn> transReport =
                t -> System.out.printf("Id: " + t.getTxnId()
                                               + " Seller: " + t.getSalesPerson()
                                               + " Buyer: " + t.getBuyerName()
                                               + " Amt: $%,9.2f%n", t.getTransactionTotal());

        // === Print PriceCo Transactions in Ascending Order ===
        System.out.println("=== PriceCo Transactions ===");

        tList.stream() // Start a stream from the transaction list
                .filter(t -> t.getBuyerName().equals("PriceCo")) // Filter only transactions for "PriceCo"
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal)) // Sort by transaction total (low to high)
                .forEach(transReport); // Print each transaction using the Consumer

        // === Print PriceCo Transactions in Descending Order ===
        System.out.println("\n=== PriceCo Transactions Reversed ===");

        tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal).reversed()) // Sort by transaction total (high to low)
                .forEach(transReport);

        // === Sort All Transactions by Buyer Name, Then Salesperson, Then Transaction Total ===
        System.out.println("\n=== Triple Sort Transactions ===");

        tList.stream()
                .sorted(
                        Comparator
                                .comparing(SalesTxn::getBuyerName) // First sort by buyer name (A-Z)
                                .thenComparing(SalesTxn::getSalesPerson) // Then by salesperson name (A-Z)
                                .thenComparing(SalesTxn::getTransactionTotal) // Then by transaction amount (low to high)
                )
                .forEach(transReport); // Print each sorted transaction
    }
}
