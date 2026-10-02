import java.util.Scanner;

/**
 * Problem 1: The Canteen Billing Counter
 * Category C - Week 8 Assignment Problem
 *
 * Demonstrates polymorphic discount calculation:
 * - Student: 10% discount
 * - Staff: 5% discount
 * - Guest: full amount + ₹10 service charge
 */
public class Problem1_CanteenBillingCounter {

    public abstract static class CustomerBill {
        protected String customerType;
        protected double rawAmount;

        public CustomerBill(String customerType, double rawAmount) {
            this.customerType = customerType;
            this.rawAmount = rawAmount;
        }

        public String getCustomerType() {
            return customerType;
        }

        public abstract double calculateFinalAmount();
    }

    public static class StudentBill extends CustomerBill {
        public StudentBill(double rawAmount) {
            super("STUDENT", rawAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return rawAmount * 0.90; // 10% discount
        }
    }

    public static class StaffBill extends CustomerBill {
        public StaffBill(double rawAmount) {
            super("STAFF", rawAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return rawAmount * 0.95; // 5% discount
        }
    }

    public static class GuestBill extends CustomerBill {
        public GuestBill(double rawAmount) {
            super("GUEST", rawAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return rawAmount + 10.0; // ₹10 service charge
        }
    }

    public static CustomerBill createBill(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT":
                return new StudentBill(amount);
            case "STAFF":
                return new StaffBill(amount);
            case "GUEST":
                return new GuestBill(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void processBills(CustomerBill[] bills) {
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
            grandTotal += finalAmount;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                CustomerBill[] bills = new CustomerBill[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double amount = scanner.nextDouble();
                    bills[i] = createBill(type, amount);
                }
                processBills(bills);
            }
            scanner.close();
            return;
        }

        System.out.println("=== The Canteen Billing Counter ===");
        CustomerBill[] sampleBills = new CustomerBill[] {
            createBill("STUDENT", 200),
            createBill("STAFF", 300),
            createBill("GUEST", 150)
        };
        processBills(sampleBills);
    }
}
