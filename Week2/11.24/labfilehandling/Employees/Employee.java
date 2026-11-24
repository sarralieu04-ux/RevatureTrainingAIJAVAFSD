import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String empName;
    private String department;
    private double salary;

    public Employee(int empId, String empName, String department, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "empId=" + empId
                + ", empName='" + empName + '\''
                + ", department='" + department + '\''
                + ", salary=" + salary
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee[] employees = {
                new Employee(101, "Alice Johnson", "Human Resources", 62000.00),
                new Employee(102, "Brian Lee", "Engineering", 85000.00),
                new Employee(103, "Alieu Sarr", "IT", 71000.00),
                new Employee(104, "Daniel Wilson", "Marketing", 68000.00),
                new Employee(105, "Eva Martinez", "Operations", 74000.00)
        };

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("employees.dat"))) {
            output.writeObject(employees);
        }

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("employees.dat"))) {
            Employee[] savedEmployees = (Employee[]) input.readObject();
            for (Employee employee : savedEmployees) {
                System.out.println(employee);
            }
        }
    }
}
