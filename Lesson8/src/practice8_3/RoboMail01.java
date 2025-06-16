package practice8_3;

/**
 * This class simulates sending emails and text messages to employees.
 * In a real application, this would connect to email servers or SMS gateways.
 */
public class RoboMail01 {

    /**
     * Simulates sending an email to an employee
     *
     * @param p The employee to email
     */
    public void roboMail ( Employee p ) {
        System.out.println("Emailing: " + p.getGivenName()
                                   + " " + p.getSurName() + " age " + p.getAge()
                                   + " at " + p.getEmail());
    }

    /**
     * Simulates sending a text message to an employee
     *
     * @param p The employee to text
     */
    public void roboText ( Employee p ) {
        System.out.println("Texting: " + p.getGivenName()
                                   + " " + p.getSurName() + " age " + p.getAge()
                                   + " at " + p.getPhone());
    }
}