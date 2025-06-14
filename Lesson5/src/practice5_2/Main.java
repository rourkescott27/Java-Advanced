package practice5_2;

public class Main {

    public static void main ( String[] args ) {

        // Create two Employee objects with different roles and salaries
        Employee jane = new Employee("Jane Doe", "Manager", "HR", 65000);
        Employee john = new Employee("John Doe", "Staff", "HR", 55000);

        // Print withholding amount for Jane (calls getWithholding)
        System.out.println("Jane is withholding: " + jane.getWithholding());

        // Print bonus amount for John (calls getBonus)
        System.out.println("John's bonus is " + john.getBonus());
    }
}

