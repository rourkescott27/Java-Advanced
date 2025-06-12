package practice2_1;

import domain.Employee;

public class EmployeeTest {
    public static void main ( String[] args ) {
        Employee emp = new Employee();

        emp.setEmpId(27);
        emp.setName("Rourke Scott");
        emp.setSsn("012-34-5678");
        emp.setSalary(15000.00);

        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee SSN: " + emp.getSsn());
        System.out.println("Employee Salary: " + emp.getSalary());
    }
}
