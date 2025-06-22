package practice10_8;

/**
 * Enum to represent different buyer classes.
 * Each buyer class has an associated discount rate.
 */
public enum BuyerClass {

    // Enum constants with their corresponding discount rates
    BASIC(0.0d),      // No discount
    SILVER(0.01d),    // 1% discount
    GOLD(0.02d),      // 2% discount
    PLATINUM(0.03d);  // 3% discount

    // Field to store the discount rate
    private final double rate;

    /**
     * Constructor for the enum.
     * Each enum constant calls this constructor with its discount rate.
     *
     * @param rate The discount rate associated with the buyer class
     */
    BuyerClass ( double rate ) {
        this.rate = rate;
    }

    /**
     * Getter method to retrieve the discount rate.
     *
     * @return The discount rate for the buyer class
     */
    public double getRate () {
        return rate;
    }
}
