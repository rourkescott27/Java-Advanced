package practice4_2.domain;

public class Manager extends Employee {

    private String deptName;

    public Manager ( int empId, String name, String ssn, double salary, String deptName ) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
    }

    public String toString () {
        return super.toString() + "\nDepartment: " + getDeptName();
    }

    public void managerMethod () {}

    public String getDeptName () {
        return deptName;
    }
}
