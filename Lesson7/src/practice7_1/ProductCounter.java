package practice7_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Map to store the count of each product part number
    private Map<String, Long> productCountMap = new HashMap<>();

    // Map to associate product names with their part numbers, sorted alphabetically by name
    private Map<String, String> productNames = new TreeMap<>();

    public static void main ( String[] args ) {

        // Array of product part numbers (some repeated to simulate sales or scans)
        String[] parts = new String[]{
                "1S01", "1S01", "1S01",
                "1S01", "1S01", "1S02",
                "1S02", "1S02", "1H01",
                "1H01", "1S02", "1S01",
                "1S01", "1H01", "1H01",
                "1H01", "1S02", "1S02",
                "1M02", "1M02", "1M02"
        };

        // Mapping of product names to part numbers
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02"); // Note: extra spaces may cause formatting issues

        // Create an instance of ProductCounter with product name mappings
        ProductCounter pc1 = new ProductCounter(productNames);

        // Count how many times each product appears in the parts list
        pc1.processList(parts);

        // Print a report showing product names and their counts
        pc1.printReport();
    }

    // Constructor to initialize the ProductCounter with product names
    public ProductCounter ( Map productNames ) {
        this.productNames = productNames;
    }

    // Method to process the list of part numbers and count their occurrences
    public void processList ( String[] list ) {
        long curVal = 0;
        for (String itemNumber : list) {
            if (productCountMap.containsKey(itemNumber)) {
                // If the item already exists, increase its count
                curVal = productCountMap.get(itemNumber);
                curVal++;
                productCountMap.put(itemNumber, Long.valueOf(curVal));
            } else {
                // If it's the first time the item appears, set its count to 1
                productCountMap.put(itemNumber, Long.valueOf(1));
            }
        }
    }

    // Method to print the final report
    public void printReport () {
        System.out.println("==== Product Report ====");
        for (String key : productNames.keySet()) {
            // Get the part number from the product name
            String partNumber = productNames.get(key);
            // Get the count of that part number from the map
            Long count = productCountMap.get(partNumber);
            System.out.print("Name: " + key);
            System.out.println("\t\tCount: " + count);
        }
    }
}
