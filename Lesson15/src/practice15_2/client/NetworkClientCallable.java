package practice15_2.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {

    // The RequestResponse object that holds host, port, and will store response
    private final RequestResponse lookup;

    // Constructor to initialize with a RequestResponse instance
    public NetworkClientCallable ( RequestResponse lookup ) {
        this.lookup = lookup;
    }

    // The call() method is executed when this Callable is run by a thread
    @Override
    public RequestResponse call () throws IOException {
        // Open a socket connection to the host and port specified in lookup
        try (Socket sock = new Socket(lookup.host, lookup.port);
             // Create a Scanner to read the input stream from the socket
             Scanner scanner = new Scanner(sock.getInputStream())) {
            // Read the response from the server (expecting one token)
            lookup.response = scanner.next();
            // Return the updated RequestResponse object
            return lookup;
        }
    }
}
