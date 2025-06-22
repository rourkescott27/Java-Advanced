package practice11_2;

public class EmployeeTest {

    public static void main ( String[] args ) throws InvalidOperationException {
        // Create an instance of EmployeeImpl to manage Employee records
        EmployeeImpl empArr = new EmployeeImpl();

        // Create Employee objects with id, first name, last name, and salary
        Employee e1 = new Employee(0, "bob", "builder", 1250.50f);
        empArr.add(e1); // Add employee to the manager

        Employee e2 = new Employee(1, "John", "Doe", 1250.50f);
        empArr.add(e2);

        Employee e3 = new Employee(5, "Jane", "Doe", 1350.50f);
        empArr.add(e3);

        // Retrieve all employees and print their details
        Employee[] allEmps = empArr.getAllEmployees();
        for (Employee employee : allEmps) {
            System.out.println(employee + "\n"); // Print each employee using overridden toString()
        }

        // Find an employee by ID (5) and print the employee if found
        Employee e = empArr.findById(5);
        if (e != null) {
            System.out.println(e + "\n"); // Print the found employee
        } else {
            System.out.println("\n\nEmployee not found"); // Inform if employee is missing
        }

        // Uncomment to test deleting an employee with ID 7
        // empArr.delete(7);
    }
}
