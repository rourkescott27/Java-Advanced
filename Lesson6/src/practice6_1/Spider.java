package practice6_1;

/**
 * Spider class that extends Animal.
 * Does not implement Pet, meaning it’s a wild animal.
 */
public class Spider extends Animal {
    public Spider () {
        super(8);  // Spiders have 8 legs
    }

    @Override
    public void eat () {
        System.out.println("The spider eats a fly.");
    }
}

