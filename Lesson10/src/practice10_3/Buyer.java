package practice10_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a buyer with a name and a buyer class (discount level).
 */
public class Buyer {

    // Fields to hold the buyer's name and their buyer class
    private String name;
    private BuyerClass buyerClass;

    /**
     * Private default constructor.
     * Prevents creating Buyer objects without specifying name and class.
     */
    private Buyer () {
        super();
    }

    /**
     * Private constructor that sets the buyer's name and buyer class.
     * Called internally to create Buyer instances.
     *
     * @param name       The name of the buyer
     * @param buyerClass The buyer's classification (e.g., BASIC, SILVER)
     */
    private Buyer ( String name, BuyerClass buyerClass ) {
        this.name = name;
        this.buyerClass = buyerClass;
    }

    /**
     * Static factory method to create new Buyer instances.
     * This is the only public way to create a Buyer object.
     *
     * @param name       The name of the buyer
     * @param buyerClass The buyer's classification
     * @return A new Buyer object
     */
    public static Buyer getInstance ( String name, BuyerClass buyerClass ) {
        return new Buyer(name, buyerClass);
    }

    /**
     * Getter method for the buyer's name.
     *
     * @return The name of the buyer
     */
    public String getName () {
        return name;
    }

    /**
     * Getter method for the buyer's class.
     *
     * @return The BuyerClass of this buyer (e.g., GOLD, SILVER)
     */
    public BuyerClass getBuyerClass () {
        return buyerClass;
    }

    /**
     * Creates and returns a map of sample buyers.
     * Each buyer is keyed by a short string (like "Acme") for easy lookup.
     *
     * @return A Map where keys are short buyer names and values are Buyer objects
     */
    public static Map<String, Buyer> getBuyerMap () {
        Map<String, Buyer> buyerMap = new HashMap<>();

        // Adding sample buyers to the map with their respective buyer classes
        buyerMap.put("Acme", Buyer.getInstance("Acme Electronics", BuyerClass.SILVER));
        buyerMap.put("BestDeals", Buyer.getInstance("Best Deals", BuyerClass.GOLD));
        buyerMap.put("GreatDeals", Buyer.getInstance("Great Deals", BuyerClass.BASIC));
        buyerMap.put("MomAndPops", Buyer.getInstance("Mom and Pops", BuyerClass.BASIC));
        buyerMap.put("RadioHut", Buyer.getInstance("Radio Hut", BuyerClass.PLATINUM));
        buyerMap.put("PriceCo", Buyer.getInstance("PriceCo", BuyerClass.SILVER));

        // Return the map containing all sample buyers
        return buyerMap;
    }
}
