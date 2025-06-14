package practice4_3;

/**
 * A Singleton class that stores a fixed list of peer host IP addresses.
 * Ensures that only one instance of this class exists throughout the application.
 */
public final class PeerSingleton {

    // An array to store IP addresses of peer hosts
    private static final String[] hostNames = new String[5];
    // The single instance of PeerSingleton, eagerly created
    private static final PeerSingleton instance = new PeerSingleton();

    // Static block to initialize the hostNames array with IP addresses
    static {
        // Read from File
        hostNames[0] = "192.168.1.2";
        hostNames[1] = "192.168.1.4";
        hostNames[2] = "192.168.2.3";
        hostNames[3] = "192.168.2.5";
        hostNames[4] = "192.168.2.14";
    }

    // Private constructor to prevent instantiation from outside the class
    private PeerSingleton () {
    }

    //Provides access to the single instance of this class.
    public static PeerSingleton getInstance() {
        return instance;
    }

    //Returns the array of host IP addresses.
    public String[] getHostNames () {
        return hostNames;
    }
}
