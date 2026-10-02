/**
 * Problem 2: Payroll Salary Management
 * Scenario: Corporate payroll account salary and bonus access control
 * 
 * Enforces data hiding for basicSalary and bonus, supporting controlled mutation
 * via creditBonus() and deductTax(), while exposing a read-only getNetSalary().
 */
public class Problem2_PayrollSalaryManagement {

    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double openingSalary) {
            if (openingSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Setting to 0.0.");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = openingSalary;
            }
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus credit rejected: amount must be strictly positive.");
            } else {
                this.bonus += amount;
                System.out.printf("Bonus credited: Rs %.1f%n", amount);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: percentage must be between 0 and 100.");
            } else {
                double deduction = basicSalary * (percent / 100.0);
                basicSalary -= deduction;
                System.out.printf("Tax deducted: %.0f%%%n", percent);
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Payroll Salary Management ===");
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.printf("Net salary: Rs %.1f%n", account.getNetSalary());
    }
}
