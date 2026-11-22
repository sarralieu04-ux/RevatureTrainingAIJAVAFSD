class Employee {
    // Mix of primitive and wrapper data types
    private int id;
    private String name;
    private Double basicSalary;
    private Double bonusPercentage;
    private Boolean active;

    public Employee(int id, String name, String basicSalaryStr, String bonusPercentageStr, String activeStr) {
        this.id = id;
        this.name = name;
        // Parse String inputs into Wrapper objects
        this.basicSalary = Double.valueOf(basicSalaryStr);
        this.bonusPercentage = Double.valueOf(bonusPercentageStr);
        this.active = Boolean.valueOf(activeStr);
    }

    // Copy constructor to demonstrate creating a completely new object
    public Employee(Employee other) {
        this.id = other.id;
        this.name = other.name;
        this.basicSalary = other.basicSalary;
        this.bonusPercentage = other.bonusPercentage;
        this.active = other.active;
    }

    public double calculateBonus() {
        return basicSalary * (bonusPercentage / 100.0);
    }

    public double calculateFinalSalary() {
        return basicSalary + calculateBonus();
    }

    public boolean isSalaryAbove75000() {
        return calculateFinalSalary() > 75000.0;
    }

    public String getUppercaseName() {
        return name.toUpperCase();
    }

    public String getReversedName() {
        return new StringBuilder(name).reverse().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + getUppercaseName());
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Final Salary: " + calculateFinalSalary());
        System.out.println("Active: " + active);
        System.out.println("Reversed Name: " + getReversedName());
        System.out.println("Salary above 75000: " + (isSalaryAbove75000() ? "Yes" : "No"));
    }
}

public class Q15 {
    public static void main(String[] args) {
        // Sample inputs received as Strings
        int idInput = 101;
        String nameInput = "Rahul";
        String salaryInput = "60000";
        String bonusInput = "20";
        String activeInput = "true";

        try {
            Employee emp1 = new Employee(idInput, nameInput, salaryInput, bonusInput, activeInput);
            emp1.displayDetails();

            // --- Demonstrating Object Reference vs. New Object ---
            System.out.println("\n--- Object Reference vs. New Object ---");

            // 1. Assigning object reference (both point to the SAME object in memory)
            Employee empReference = emp1;
            empReference.setName("Amit");
            System.out.println("After modifying reference -> emp1 name: " + emp1.getName()); // Prints "Amit"

            // Reset name back to Rahul
            emp1.setName("Rahul");

            // 2. Creating a new object (independent copy in memory)
            Employee empNewObject = new Employee(emp1);
            empNewObject.setName("Vikram");
            System.out.println("After modifying new object -> emp1 name: " + emp1.getName()); // Remains "Rahul"
            System.out.println("New object name: " + empNewObject.getName()); // Prints "Vikram"

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input for salary or bonus percentage.");
        }

        // --- Demonstrating Invalid Salary Input Handling ---
        System.out.println("\n--- Invalid Salary Test ---");
        try {
            Employee invalidEmp = new Employee(102, "Priya", "sixty_thousand", "15", "true");
            invalidEmp.displayDetails();
        } catch (NumberFormatException e) {
            System.out.println("Caught Exception: Unable to process employee 102 due to invalid salary format (" + e.getMessage() + ").");
        }
    }
}
