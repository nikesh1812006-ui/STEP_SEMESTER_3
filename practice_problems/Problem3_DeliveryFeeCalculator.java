import java.util.Scanner;

/**
 * Problem 3: Delivery Fee Calculator
 * Category C - Week 8 Practice Problem
 *
 * Demonstrates polymorphic fee calculation across Standard, Express, and
 * International delivery requests with distinct base rates, weight/distance logic,
 * and customs fees.
 */
public class Problem3_DeliveryFeeCalculator {

    public abstract static class DeliveryRequest {
        protected String type;
        protected double weight;
        protected double distance;

        public DeliveryRequest(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFee();
    }

    public static class StandardDelivery extends DeliveryRequest {
        public StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 5.0 + (0.50 * weight) + (0.10 * distance);
        }
    }

    public static class ExpressDelivery extends DeliveryRequest {
        public ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 15.0 + (1.00 * weight) + (0.20 * distance);
        }
    }

    public static class InternationalDelivery extends DeliveryRequest {
        private double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double calculateFee() {
            return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    public static void processDeliveries(DeliveryRequest[] requests) {
        double grandTotal = 0.0;
        for (DeliveryRequest req : requests) {
            double fee = req.calculateFee();
            System.out.printf("%s: %.2f%n", req.getType(), fee);
            grandTotal += fee;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                DeliveryRequest[] requests = new DeliveryRequest[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double weight = scanner.nextDouble();
                    double distance = scanner.nextDouble();
                    if (type.equalsIgnoreCase("INTERNATIONAL")) {
                        double customs = scanner.nextDouble();
                        requests[i] = new InternationalDelivery(weight, distance, customs);
                    } else if (type.equalsIgnoreCase("EXPRESS")) {
                        requests[i] = new ExpressDelivery(weight, distance);
                    } else {
                        requests[i] = new StandardDelivery(weight, distance);
                    }
                }
                processDeliveries(requests);
            }
            scanner.close();
            return;
        }

        System.out.println("=== Delivery Fee Calculator ===");
        DeliveryRequest[] sampleRequests = new DeliveryRequest[] {
            new StandardDelivery(10, 50),
            new ExpressDelivery(5, 20),
            new InternationalDelivery(20, 100, 30)
        };
        processDeliveries(sampleRequests);
    }
}
