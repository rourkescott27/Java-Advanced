package practice10_4;

import java.util.List;
import java.util.OptionalDouble;

public class CalcTest {

    public static void main ( String[] args ) {

        // Create a list of sales transactions
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // === Calculate and Print Total Transaction Amounts by Buyer ===
        System.out.println("=== Transactions Totals ===");

        // Sum up the total transaction amount for buyer "Radio Hut"
        double t1 = tList.stream() // Start a stream
                .filter(t -> t.getBuyerName().equals("Radio Hut")) // Filter transactions by buyer name
                .mapToDouble(t -> t.getTransactionTotal()) // Convert each transaction to its total amount
                .sum(); // Sum all the values
        System.out.printf("Radio Hut Total: $%,9.2f%n", t1); // Print result formatted to 2 decimal places

        // Sum up the total transaction amount for buyer "PriceCo"
        double t2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                .mapToDouble(t -> t.getTransactionTotal())
                .sum();
        System.out.printf("PriceCo Total: $%,9.2f%n", t2);

        // Sum up the total transaction amount for buyer "Best Deals"
        double t3 = tList.stream()
                .filter(t -> t.getBuyerName().equals("Best Deals"))
                .mapToDouble(t -> t.getTransactionTotal())
                .sum();
        System.out.printf("Best Deals Total: $%,9.2f%n", t3);

        // === Calculate and Print Average Unit Counts by Product ===
        System.out.println("=== Average Unit Count ===");

        // Calculate the average number of units sold for product "Widget Pro"
        OptionalDouble a1 = tList.stream()
                .filter(t -> t.getProduct().equals("Widget Pro")) // Filter by product name
                .mapToDouble(t -> t.getUnitCount()) // Get unit count for each matching transaction
                .average(); // Calculate average

        // Print the average if it was calculated successfully (i.e., not empty)
        if (a1.isPresent()) {
            System.out.printf("Widget Pro Avg: %,9.0f%n", a1.getAsDouble());
        }

        // Calculate the average number of units sold for product "Widget"
        OptionalDouble a2 = tList.stream()
                .filter(t -> t.getProduct().equals("Widget"))
                .mapToDouble(t -> t.getUnitCount())
                .average();

        if (a2.isPresent()) {
            System.out.printf("Widget Avg: %,9.0f%n", a2.getAsDouble());
        }
    }
}
