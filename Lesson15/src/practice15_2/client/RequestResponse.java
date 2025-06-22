package practice15_2.client;

import java.util.Objects;

public class RequestResponse {

    // The host name or IP address for the request
    public String host;

    // The port number for the request
    public int port;

    // The response received from the server
    public String response;

    // Constructor to create a RequestResponse with host and port
    public RequestResponse ( String host, int port ) {
        this.host = host;
        this.port = port;
    }

    // Override equals method to compare two RequestResponse objects
    // They are considered equal if their host and port are the same
    @Override
    public boolean equals ( Object obj ) {
        if (obj instanceof RequestResponse) {
            RequestResponse lookup = (RequestResponse) obj;
            return host.equals(lookup.host) && port == lookup.port;
        }
        return false;
    }

    // Override hashCode method to ensure consistency with equals
    // Generates a hash code based on host and port
    @Override
    public int hashCode () {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.host);
        hash = 97 * hash + this.port;
        return hash;
    }
}
