package practice6_1;

/**
 * Cat class that extends Animal and implements Pet.
 * Adds pet-specific behavior like playing and naming.
 */
public class Cat extends Animal implements Pet {
    private String name;

    // Constructor with a name
    public Cat ( String name ) {
        super(4); // Cats have 4 legs
        this.name = name;
    }

    // Default constructor using the name "Fluffy"
    public Cat () {
        this("Fluffy");
    }

    @Override
    public void play () {
        System.out.println(name + " likes playing with string.");
    }

    @Override
    public void eat () {
        System.out.println("Cats like to eat spider and fish.");
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public void setName ( String name ) {
        this.name = name;
    }
}

