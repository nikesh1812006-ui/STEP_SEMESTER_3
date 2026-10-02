/**
 * Problem 1: The Piggy Bank
 * Category C - Week 7 Practice Problem
 *
 * Requirements:
 * - The savings amount must be private, changed only by deposit and withdraw methods.
 * - A withdrawal larger than the current savings must be rejected, not applied.
 * - Give the piggy bank a final ID that's fixed the moment it's created.
 * - Provide a way to check current savings, but no way to set it directly.
 */
public class Problem1_ThePiggyBank {

    public static class PiggyBank {
        private final String id;
        private double savings;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0.0;
        }

        public String getId() {
            return id;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                savings += amount;
                System.out.printf("Deposited: %.2f | Current Savings: %.2f%n", amount, savings);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
                return false;
            }
            if (amount > savings) {
                System.out.printf("Withdrawal of %.2f rejected! Insufficient funds. Savings stays: %.2f%n", amount, savings);
                return false;
            }
            savings -= amount;
            System.out.printf("Withdrew: %.2f | Remaining Savings: %.2f%n", amount, savings);
            return true;
        }

        public double getSavings() {
            return savings;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Piggy Bank ID: " + pb.getId());
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("Final Savings: " + pb.getSavings());
    }
}
