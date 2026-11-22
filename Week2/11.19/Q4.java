public class Q4 {
    public static void main(String[] args) {
        // Given String inputs
        String age = "25";
        String salary = "45000.75";
        String active = "true";

        // Convert Strings into Wrapper Class objects
        Integer ageObj = Integer.valueOf(age);
        Double salaryObj = Double.valueOf(salary);
        Boolean activeObj = Boolean.valueOf(active);

        // 2. Calculate salary after a 10% increment
        Double updatedSalary = salaryObj + (salaryObj * 0.10);

        // 3. Print all values and their corresponding data types
        System.out.println("Age: " + ageObj + " | Data Type: " + ageObj.getClass().getSimpleName());
        System.out.println("Original Salary: " + salaryObj + " | Data Type: " + salaryObj.getClass().getSimpleName());
        System.out.println("Updated Salary (10% increment): " + updatedSalary + " | Data Type: " + updatedSalary.getClass().getSimpleName());
        System.out.println("Active: " + activeObj + " | Data Type: " + activeObj.getClass().getSimpleName());
    }
}
