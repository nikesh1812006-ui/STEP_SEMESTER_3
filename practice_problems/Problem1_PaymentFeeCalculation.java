import java.util.Scanner;

/**
 * Problem 1: Payment System Fee Calculation
 * Category C - Week 8 Practice Problem
 *
 * Demonstrates polymorphism:
 * Base class Payment with specialized derived classes CardPayment, WalletPayment,
 * and BankTransferPayment overriding calculateAdjustedAmount().
 */
public class Problem1_PaymentFeeCalculation {

    public abstract static class Payment {
        protected String type;
        protected double amount;

        public Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public abstract double calculateAdjustedAmount();
    }

    public static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super("CARD", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.02; // 2% fee
        }
    }

    public static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super("WALLET", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.01; // 1% fee
        }
    }

    public static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount; // 0% fee
        }
    }

    public static Payment createPayment(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void processPayments(Payment[] payments) {
        double grandTotal = 0.0;
        for (Payment payment : payments) {
            double adjusted = payment.calculateAdjustedAmount();
            System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
            grandTotal += adjusted;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                Payment[] payments = new Payment[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double amount = scanner.nextDouble();
                    payments[i] = createPayment(type, amount);
                }
                processPayments(payments);
            }
            scanner.close();
            return;
        }

        System.out.println("=== Payment System Fee Calculation ===");
        Payment[] samplePayments = new Payment[] {
            createPayment("CARD", 1000),
            createPayment("WALLET", 500),
            createPayment("BANKTRANSFER", 2000)
        };
        processPayments(samplePayments);
    }
}
