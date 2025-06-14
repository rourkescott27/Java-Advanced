package practice4_3;

/*
 * Singleton Pattern Summary:
 * The Singleton design pattern ensures that a class has only one instance
 * throughout the application and provides a global point of access to it.
 *
 * This is useful when exactly one object is needed to coordinate actions
 * across the system — for example, configuration managers, logging services,
 * or in this case, a shared list of peer host names.
 */

public class Main {
    public static void main ( String[] args ) {
        // Retrieve the singleton instance of PeerSingleton twice
        PeerSingleton peerList01 = PeerSingleton.getInstance();
        PeerSingleton peerList02 = PeerSingleton.getInstance();

        // Loop through and print the host names using the first reference
        for(String hostName: peerList01.getHostNames()) {
            System.out.println("Host name: " + hostName);
        }

        System.out.println();

        // Loop through and print the host names using the second reference
        for(String hostName: peerList02.getHostNames()) {
            System.out.println("Host name: " + hostName);
        }

        // Note: peerList01 and peerList02 point to the same object (singleton),
        // so the output from both loops will be identical.
    }
}
