package practice18_1;

import java.sql.*;
import java.util.Date;

public class SimpleJDBCExample {
    public static void main ( String[] args ) {
        // Define the database connection URL
        // This connects to an embedded Derby database called "EmployeeTable"
        // The "create=true" part means the database will be created if it doesn't exist
        String url = "jdbc:derby:EmployeeTable;create=true"; // embedded mode

        // Username and password are not needed here because embedded Derby does not require them
        /** String username = "tiger";
         String password = "scott"; */

        // Define the SQL query string to select all records from the EMPLOYEE table
        String query = "SELECT * FROM EMPLOYEE";

        // Try-with-resources block to automatically close resources like Connection and Statement
        try (Connection con = DriverManager.getConnection(url)) {
            // Create a Statement object to send SQL commands to the database
            Statement stmt = con.createStatement();

            // Execute the SELECT query and get the results in a ResultSet
            ResultSet rs = stmt.executeQuery(query);

            // Loop through each row in the ResultSet
            while (rs.next()) {
                // Retrieve data from each column of the current row
                int empID = rs.getInt("ID");
                String first = rs.getString("FIRSTNAME");
                String last = rs.getString("LASTNAME");
                Date birth_date = rs.getDate("BIRTHDATE");
                float salary = rs.getFloat("SALARY");

                // Print employee information to the console
                System.out.println("Employee ID:   " + empID + "\n"
                                           + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                                           + "Birth Date:    " + birth_date + "\n"
                                           + "Salary:        " + salary + "\n");
            }

            // Create an SQL query to insert a new employee record into the EMPLOYEE table
            query = "INSERT INTO EMPLOYEE VALUES (400, 'Bill', 'Murray','1950-09-21', 150000)";

            // Execute the insert query and check if exactly one row was inserted
            if (stmt.executeUpdate(query) != 1) {
                System.out.println("Failed to add a new employee record");
            }
        } catch (SQLException e) {
            // Catch any SQL exceptions (errors) and print an error message
            System.out.println("Exception creating connection: " + e);
            System.exit(0);  // Exit the program if a database error occurs
        }

        // No need to explicitly close the Connection and Statement objects because
        // try-with-resources automatically closes them after the try block finishes
    }

}
