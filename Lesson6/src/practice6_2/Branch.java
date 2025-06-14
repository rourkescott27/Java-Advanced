package practice6_2;

/**
 * Enum representing different bank branch locations in South Africa.
 * Each branch has an associated service level: "Basic", "Loan", or "Full".
 */
public enum Branch {
    // Enum constants, each representing a branch and its service level
    CAPE_TOWN("Basic"),
    DURBAN("Loan"),
    JOHANNESBURG("Full"),
    PORT_ELIZABETH("Full");

    // Field to store the service level for the branch
    String serviceLevel;

    /**
     * Constructor for the enum.
     * Each enum constant passes its service level as an argument.
     *
     * @param serviceLevel the level of service offered at the branch
     */
    private Branch ( String serviceLevel ) {
        this.serviceLevel = serviceLevel;
    }

    /**
     * Getter method to retrieve the service level of the branch.
     *
     * @return the service level as a String
     */
    public String getServiceLevel () {
        return serviceLevel;
    }
}

