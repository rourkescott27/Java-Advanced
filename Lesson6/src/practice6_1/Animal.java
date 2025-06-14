package practice6_1;

/**
 * Abstract class representing a generic animal.
 * Provides base behavior and structure for all animals.
 */
public abstract class Animal {
    protected int legs;  // Number of legs the animal has

    public Animal ( int legs ) {
        this.legs = legs;
    }

    // Generic walking behavior shared by all animals
    public void walk () {
        System.out.println("This animal walks on " + legs + " legs.");
    }

    // Abstract method to be implemented by subclasses
    public abstract void eat ();
}

