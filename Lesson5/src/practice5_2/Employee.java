package practice5_2;

public class Employee {
    // Basic employee details
    private String name;
    private String role;
    private String dept;
    private double salary;

    // Default constructor
    public Employee () {
        super();
    }

    // Constructor with parameters
    public Employee ( String name, String role, String dept, double salary ) {
        this.name = name;
        this.role = role;
        this.dept = dept;
        this.salary = salary;
    }

    /**
     * Private inner class used to calculate employee benefits.
     * Only accessible within the outer Employee class.
     */
    private class BenefitsHelper {
        // Constants for bonus and withholding rates
        private final double bonusRate = 0.02;         // 2% bonus
        private final double withholdingRate = 0.07;   // 7% tax withholding

        // Calculate bonus based on salary
        protected double calcBonus ( double salary ) {
            return salary * bonusRate;
        }

        // Calculate withholding based on salary
        protected double calcWithholding ( double salary ) {
            return salary * withholdingRate;
        }
    }

    // Create an instance of the helper class
    private BenefitsHelper helper = new BenefitsHelper();

    // Getter methods for employee information
    public String getName () {
        return name;
    }

    public String getRole () {
        return role;
    }

    public String getDept () {
        return dept;
    }

    public double getSalary () {
        return salary;
    }

    // Returns the calculated bonus using the helper class
    public double getBonus () {
        return helper.calcBonus(salary);
    }

    // Returns the calculated withholding using the helper class
    public double getWithholding () {
        return helper.calcWithholding(salary);
    }
}

