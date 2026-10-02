/**
 * Problem 3: Employee Profile Creation
 * Scenario: Intern vs. permanent employee onboarding with shared constructor logic
 *
 * Demonstrates constructor chaining via this(...) — the intern constructor delegates
 * to the full-parameter constructor with salary=0, then overrides isIntern to true.
 */
public class Problem3_EmployeeProfileCreation {

    public static class Employee {
        private String empId;
        private String empName;
        private double salary;
        private boolean isIntern;

        // Full constructor for permanent employees
        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // Intern constructor chains to full constructor with salary = 0
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.printf("%s | %s | Rs %.1f | Intern: %b%n",
                    empId, empName, salary, isIntern);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Employee Profile Creation ===");
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
