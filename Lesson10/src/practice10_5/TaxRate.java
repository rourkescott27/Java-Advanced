package practice10_5;

// Enum to represent tax rates for different U.S. states
public enum TaxRate {

    // Enum constants representing states and their respective tax rates
    CA(0.09d),  // California - 9% tax
    CO(0.08d),  // Colorado - 8% tax
    MA(0.09d);  // Massachusetts - 9% tax

    // Private field to store the tax rate for each state
    private final double rate;

    // Constructor for the enum, called once for each enum constant
    // It sets the tax rate for the corresponding state
    TaxRate ( double rate ) {
        this.rate = rate;
    }

    // Getter method to retrieve the tax rate
    public double getRate () {
        return rate;
    }

    // Static method that returns the tax rate based on the provided state
    public static double byState ( State s ) {
        double rate = 0.0d; // Default rate (in case state doesn't match)

        // Check the input state and assign the correct tax rate
        switch (s) {
            case CA:
                rate = CA.getRate(); // Get rate for California
                break;
            case CO:
                rate = CO.getRate(); // Get rate for Colorado
                break;
            case MA:
                rate = MA.getRate(); // Get rate for Massachusetts
                break;
        }

        return rate; // Return the matched tax rate
    }

}
