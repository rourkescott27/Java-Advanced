package practice6_1;

/**
 * Interface representing a pet.
 * Requires implementing classes to define how pets are named and played with.
 */
public interface Pet {
    String getName ();

    void setName ( String name );

    void play ();
}

