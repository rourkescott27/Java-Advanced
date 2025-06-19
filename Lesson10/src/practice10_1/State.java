package practice10_1;

// Enum to represent different U.S. states by their abbreviations
public enum State {

    // Enum constants for each state with their string abbreviation
    CA("CA"),  // California
    CO("CO"),  // Colorado
    MA("MA");  // Massachusetts

    // Private field to store the string representation of the state
    private final String str;

    // Constructor for the enum
    // This constructor is called once for each enum constant above
    // It assigns the provided abbreviation to the 'str' field
    State ( String stateStr ) {
        this.str = stateStr;
    }

    // Getter method to retrieve the state's abbreviation as a string
    public String getStr () {
        return str;
    }

}
