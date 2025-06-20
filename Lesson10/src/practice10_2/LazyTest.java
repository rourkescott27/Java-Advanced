package practice10_2;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LazyTest {

    public static void main ( String[] args ) {

        // Create a list of sample SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define how each transaction should be printed (Seller, Buyer, Quantity)
        Consumer<SalesTxn> quantReport =
                t -> System.out.printf("Seller: "
                                               + t.getSalesPerson() + "-- Buyer: " + t.getBuyerName()
                                               + " -- Quantity: %,9.0f%n", t.getUnitCount());

        // Define what to print when a stream starts processing an item
        Consumer<SalesTxn> streamStart =
                t -> System.out.println("Stream start: " + t.getSalesPerson()
                                                + " ID: " + t.getTxnId());

        // Define what to print when filtering by state
        Consumer<SalesTxn> stateSearch =
                t -> System.out.println("State Search: " + t.getSalesPerson()
                                                + " St: " + t.getState());

        // Define what to print when filtering by product
        Consumer<SalesTxn> productSearch =
                t -> System.out.println("Product Search");

        // --- FIRST EXAMPLE: Filter and print matching transactions directly ---
        System.out.println("=== Widget Pro Quantity in CO ===");
        tList.stream()
                .filter(t -> t.getProduct().equals("Widget Pro"))  // Only keep Widget Pro
                .filter(t -> t.getState().equals(State.CO))        // Only keep those from CO
                .forEach(quantReport);                                      // Print results

        // --- SECOND EXAMPLE: Add peek() to observe stream steps ---
        System.out.println("\n=== Widget Pro Quantity in CO ===");
        tList.stream()
                .peek(streamStart)                                         // Peek at start of stream
                .filter(t -> t.getState().equals(State.CO))       // Filter by state
                .peek(stateSearch)                                         // Peek after state filter
                .filter(t -> t.getProduct().equals("Widget Pro")) // Filter by product
                .peek(productSearch)                                       // Peek after product filter
                .forEach(quantReport);                                     // Print results

        // --- THIRD EXAMPLE: Use findFirst() to get the first matching item ---
        System.out.println("\n=== Widget Pro Quantity in CO (FindFirst)===");
        Optional<SalesTxn> ft = tList.stream()
                .peek(streamStart)                                         // Peek at start
                .filter(t -> t.getState().equals(State.CO))       // Filter by state
                .peek(stateSearch)                                         // Peek after state filter
                .filter(t -> t.getProduct().equals("Widget Pro")) // Filter by product
                .peek(productSearch)                                       // Peek after product filter
                .findFirst();                                              // Get the first match (if any)

        // If a match was found, print the details using quantReport
        if (ft.isPresent()) {
            quantReport.accept(ft.get());
        }

    }
}
