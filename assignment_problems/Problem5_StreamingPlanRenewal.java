import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Problem 5: The Streaming Plan Renewal Reminder
 * Category C - Week 8 Assignment Problem
 *
 * Demonstrates polymorphic renewal calculation:
 * - Basic plan: valid for 30 days
 * - Standard plan: valid for 90 days
 * - Premium plan: valid for 365 days
 * Calculates renewal date = startDate.plusDays(validityDays).
 */
public class Problem5_StreamingPlanRenewal {

    public abstract static class SubscriptionPlan {
        protected String planType;
        protected String subscriberName;
        protected LocalDate startDate;

        public SubscriptionPlan(String planType, String subscriberName, LocalDate startDate) {
            this.planType = planType;
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        public String getSubscriberName() {
            return subscriberName;
        }

        public abstract int getValidityDays();

        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    public static class BasicPlan extends SubscriptionPlan {
        public BasicPlan(String subscriberName, LocalDate startDate) {
            super("BASIC", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 30;
        }
    }

    public static class StandardPlan extends SubscriptionPlan {
        public StandardPlan(String subscriberName, LocalDate startDate) {
            super("STANDARD", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 90;
        }
    }

    public static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan(String subscriberName, LocalDate startDate) {
            super("PREMIUM", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 365;
        }
    }

    public static SubscriptionPlan createPlan(String planType, String name, String dateStr) {
        LocalDate startDate = LocalDate.parse(dateStr);
        switch (planType.toUpperCase()) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + planType);
        }
    }

    public static void displayRenewals(SubscriptionPlan[] plans) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (SubscriptionPlan plan : plans) {
            LocalDate renewal = plan.calculateRenewalDate();
            System.out.printf("%s: %s%n", plan.getSubscriberName(), renewal.format(formatter));
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = Integer.parseInt(scanner.nextLine().trim());
                SubscriptionPlan[] plans = new SubscriptionPlan[n];
                for (int i = 0; i < n; i++) {
                    String line = scanner.nextLine().trim();
                    String[] tokens = line.split("\\s+");
                    plans[i] = createPlan(tokens[0], tokens[1], tokens[2]);
                }
                displayRenewals(plans);
            }
            scanner.close();
            return;
        }

        System.out.println("=== The Streaming Plan Renewal Reminder ===");
        SubscriptionPlan[] samplePlans = new SubscriptionPlan[] {
            createPlan("BASIC", "Asha", "2024-01-15"),
            createPlan("STANDARD", "Ravi", "2024-02-01"),
            createPlan("PREMIUM", "Neha", "2024-03-10"),
            createPlan("BASIC", "Kiran", "2024-12-20")
        };
        displayRenewals(samplePlans);
    }
}
