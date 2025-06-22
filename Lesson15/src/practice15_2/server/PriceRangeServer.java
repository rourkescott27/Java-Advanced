package practice15_2.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PriceRangeServer implements Runnable {

    private String price;      // The random price generated for clients
    private ServerSocket ss;  // Server socket to listen for client connections

    // Constructor initializes the server socket on the given port
    // Also generates a random price between low (inclusive) and high (exclusive)
    public PriceRangeServer ( int port, int low, int high ) throws IOException {
        ss = new ServerSocket(port);           // Create server socket listening on port
        ss.setSoTimeout(250);                   // Set timeout for accept() to 250 milliseconds
        // Generate random price between low and high
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f", d);      // Format price as a string with 2 decimal places
    }

    // Method to accept client connections and send the price
    public void accept () throws IOException {
        System.out.println("Accepting connections on port " + ss.getLocalPort());
        // Keep accepting connections until the thread is interrupted
        while (!Thread.interrupted()) {
            try (
                    Socket sock = ss.accept();                          // Wait for a client to connect
                    BufferedWriter bw = new BufferedWriter(
                            new OutputStreamWriter(sock.getOutputStream())) // Writer to send data to client
            ) {
                try {
                    Thread.sleep(2000); // Simulate some processing delay (2 seconds)
                } catch (InterruptedException ex) {
                    return;            // Exit if the thread is interrupted during sleep
                }
                bw.write(price);        // Send the price string to the client
            } catch (SocketTimeoutException ste) {
                // Accept times out every 250 ms to allow checking for thread interruption
            }
        }
        System.out.println("Done accepting");
    }

    // The run() method required by Runnable interface to start server thread
    @Override
    public void run () {
        try {
            accept(); // Start accepting client connections
        } catch (IOException ex) {
            ex.printStackTrace(); // Print any IO exceptions
        }
    }
}
