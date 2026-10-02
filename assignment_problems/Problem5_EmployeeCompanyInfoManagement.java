/**
 * Problem 5: Employee and Company Information Management
 * Scenario: Shared company name metadata and employee count tracking
 *
 * Replaces per-instance company name duplication with a shared static field,
 * and tracks instantiation count using a static counter incremented in the constructor.
 * printCompanyInfo() is a static method — it must not reference any instance field.
 */
public class Problem5_EmployeeCompanyInfoManagement {

    public static class Employee {
        private String empName;
        private double salary;

        // Shared across all instances
        private static String companyName = "Bright Horizon Technologies";
        private static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        // Static method – no access to instance fields allowed
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }

        public String getEmpName() { return empName; }
        public double getSalary()  { return salary;  }
    }

    public static void main(String[] args) {
        System.out.println("=== Employee and Company Information Management ===");
        Employee e1 = new Employee("Asha",   45000);
        Employee e2 = new Employee("Bharat", 52000);
        Employee e3 = new Employee("Chitra", 38000);

        // Call through class name, not via any object reference
        Employee.printCompanyInfo();
    }
}
