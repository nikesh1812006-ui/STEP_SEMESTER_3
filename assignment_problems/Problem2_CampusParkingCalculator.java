import java.util.Scanner;

/**
 * Problem 2: The Campus Parking Charge Calculator
 * Category C - Week 8 Assignment Problem
 *
 * Demonstrates polymorphic parking calculation across vehicle types:
 * - Bike: ₹10/hr
 * - Car: ₹30 first hour + ₹20 each additional hour
 * - Truck: ₹50/hr with minimum charge of ₹100
 */
public class Problem2_CampusParkingCalculator {

    public abstract static class ParkedVehicle {
        protected String vehicleType;
        protected int hours;

        public ParkedVehicle(String vehicleType, int hours) {
            this.vehicleType = vehicleType;
            this.hours = hours;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public abstract double calculateCharge();
    }

    public static class BikeVehicle extends ParkedVehicle {
        public BikeVehicle(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return hours * 10.0;
        }
    }

    public static class CarVehicle extends ParkedVehicle {
        public CarVehicle(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + (hours - 1) * 20.0;
        }
    }

    public static class TruckVehicle extends ParkedVehicle {
        public TruckVehicle(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            double raw = hours * 50.0;
            return Math.max(100.0, raw); // minimum ₹100
        }
    }

    public static ParkedVehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new BikeVehicle(hours);
            case "CAR":
                return new CarVehicle(hours);
            case "TRUCK":
                return new TruckVehicle(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void processVehicles(ParkedVehicle[] vehicles) {
        double grandTotal = 0.0;
        for (ParkedVehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", v.getVehicleType(), charge);
            grandTotal += charge;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                ParkedVehicle[] vehicles = new ParkedVehicle[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    int hours = scanner.nextInt();
                    vehicles[i] = createVehicle(type, hours);
                }
                processVehicles(vehicles);
            }
            scanner.close();
            return;
        }

        System.out.println("=== The Campus Parking Charge Calculator ===");
        ParkedVehicle[] sampleVehicles = new ParkedVehicle[] {
            createVehicle("BIKE", 3),
            createVehicle("CAR", 4),
            createVehicle("TRUCK", 1),
            createVehicle("CAR", 1)
        };
        processVehicles(sampleVehicles);
    }
}
