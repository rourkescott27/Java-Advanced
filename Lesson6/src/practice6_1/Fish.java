package practice6_1;

/**
 * Fish class that extends Animal and implements Pet.
 * Overrides walk behavior and defines how fish act as pets.
 */
public class Fish extends Animal implements Pet {
    private String name;

    // Fish have 0 legs
    public Fish () {
        super(0);
    }

    /**
     * This method overrides the abstract method from the Animal class.
     * Since Animal is abstract, we are required to implement its abstract methods,
     * in this case: eat().
     */
    @Override
    public void eat () {
        System.out.println("Fish eat pond scum!!");
    }

    @Override
    public void play () {
        System.out.println("Just keep swimming!!");
    }

    @Override
    public void walk () {
        // Call the superclass method for default walking message
        super.walk();
        System.out.println("Fish can't walk - they swim!!");
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


