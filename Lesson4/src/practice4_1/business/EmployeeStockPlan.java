package practice4_1.business;

import practice4_1.domain.Director;
import practice4_1.domain.Employee;
import practice4_1.domain.Manager;

// This class determines how many stock options an employee should receive
// based on their position (Director > Manager > all other Employees)
public class EmployeeStockPlan {

    // Define the fixed number of shares granted to each role
    private final int employeeShares = 10;
    private final int managerShares = 100;
    private final int directorShares = 1000;

    // Grant stock options depending on the employee's specific type
    public int grantStock ( Employee emp ) {
        if (emp instanceof Director) {
            return directorShares;
        } else if (emp instanceof Manager) {
            return managerShares;
        } else {
            return employeeShares;
        }
    }
}

