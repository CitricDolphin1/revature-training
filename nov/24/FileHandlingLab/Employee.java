import java.io.Serializable;

public class Employee implements Serializable{
    int empId;
    String empName;
    String department;
    double salary;

    private static final long serialVersionUID = 1;

    Employee(int empId, String empName, String department, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + empId + " | Name: " + empName + " | Department: " + department + " | Salary: $" + salary;
    }

}