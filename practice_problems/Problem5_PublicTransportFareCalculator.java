import java.util.Scanner;

/**
 * Problem 5: Public Transport Fare Calculator
 * Category C - Week 8 Practice Problem
 *
 * Demonstrates polymorphic calculation for public transit journeys:
 * - Bus: base $2 + $0.10/km, max $10
 * - Train: base $3 + $0.15/km
 * - Metro: (base $1.50 + $0.20/km) * PeakHourFactor
 */
public class Problem5_PublicTransportFareCalculator {

    public abstract static class Journey {
        protected String transportType;
        protected double distance;

        public Journey(String transportType, double distance) {
            this.transportType = transportType;
            this.distance = distance;
        }

        public String getTransportType() {
            return transportType;
        }

        public abstract double calculateFare();
    }

    public static class BusJourney extends Journey {
        public BusJourney(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            double fare = 2.0 + (0.10 * distance);
            return Math.min(10.0, fare); // capped at max $10
        }
    }

    public static class TrainJourney extends Journey {
        public TrainJourney(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            return 3.0 + (0.15 * distance);
        }
    }

    public static class MetroJourney extends Journey {
        private double peakHourFactor;

        public MetroJourney(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double calculateFare() {
            return (1.50 + (0.20 * distance)) * peakHourFactor;
        }
    }

    public static void processJourneys(Journey[] journeys) {
        double grandTotalFare = 0.0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            System.out.printf("%s: %.2f%n", j.getTransportType(), fare);
            grandTotalFare += fare;
        }
        System.out.printf("Total: %.2f%n", grandTotalFare);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                Journey[] journeys = new Journey[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    double distance = scanner.nextDouble();
                    if (type.equalsIgnoreCase("METRO")) {
                        double factor = scanner.nextDouble();
                        journeys[i] = new MetroJourney(distance, factor);
                    } else if (type.equalsIgnoreCase("TRAIN")) {
                        journeys[i] = new TrainJourney(distance);
                    } else {
                        journeys[i] = new BusJourney(distance);
                    }
                }
                processJourneys(journeys);
            }
            scanner.close();
            return;
        }

        System.out.println("=== Public Transport Fare Calculator ===");
        Journey[] sampleJourneys = new Journey[] {
            new BusJourney(15),
            new TrainJourney(50),
            new MetroJourney(10, 1.5)
        };
        processJourneys(sampleJourneys);
    }
}
