package practice6_1;

/**
 * Main class to test various animal and pet behaviors.
 */
public class PetMain {
    public static void main ( String[] args ) {
        Animal a;

        // Test Spider using Spider reference
        Spider s = new Spider();
        s.eat();
        s.walk();

        // Test Spider using Animal reference
        a = new Spider();
        a.eat();
        a.walk();

        Pet p;

        // Test Cat using different references
        Cat c = new Cat("Tom");
        c.eat();
        c.walk();
        c.play();

        a = new Cat();  // default cat
        a.eat();
        a.walk();

        p = new Cat();
        p.setName("Jerry");
        p.play();

        // Test Fish behavior
        Fish f = new Fish();
        f.setName("Baber");
        f.eat();
        f.walk();
        f.play();

        a = new Fish();
        a.eat();
        a.walk();

        // Use playWithAnimal method to check if animal is a pet
        playWithAnimal(s);
        playWithAnimal(c);
        playWithAnimal(f);
    }

    /**
     * Accepts an Animal and checks if it is also a Pet.
     * If yes, plays with it. If not, warns of a wild animal.
     */
    public static void playWithAnimal ( Animal a ) {
        if (a instanceof Pet) {
            Pet p = (Pet) a;
            p.play();
        } else {
            System.out.println("Danger! Wild Animal!");
        }
    }
}

