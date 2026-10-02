import java.util.Scanner;

/**
 * Problem 4: The Festival Bonus Calculator
 * Category C - Week 8 Assignment Problem
 *
 * Demonstrates polymorphic bonus calculation across different employee types:
 * - Full-time employee: 10% of monthly salary
 * - Part-time employee: 5% of monthly salary
 * - Intern: fixed bonus of ₹2,000
 */
public class Problem4_FestivalBonusCalculator {

    public abstract static class Employee {
        protected String employeeType;
        protected String name;
        protected double monthlySalary;

        public Employee(String employeeType, String name, double monthlySalary) {
            this.employeeType = employeeType;
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getEmployeeType() {
            return employeeType;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateBonus();
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super("FULLTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.10; // 10%
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super("PARTTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.05; // 5%
        }
    }

    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super("INTERN", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return 2000.0; // Flat ₹2000
        }
    }

    public static Employee createEmployee(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new InternEmployee(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void processBonuses(Employee[] employees) {
        double grandTotal = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
            grandTotal += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                Employee[] employees = new Employee[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    String name = scanner.next();
                    double salary = scanner.nextDouble();
                    employees[i] = createEmployee(type, name, salary);
                }
                processBonuses(employees);
            }
            scanner.close();
            return;
        }

        System.out.println("=== The Festival Bonus Calculator ===");
        Employee[] sampleEmployees = new Employee[] {
            createEmployee("FULLTIME", "Asha", 50000),
            createEmployee("PARTTIME", "Ravi", 30000),
            createEmployee("INTERN", "Neha", 15000)
        };
        processBonuses(sampleEmployees);
    }
}
