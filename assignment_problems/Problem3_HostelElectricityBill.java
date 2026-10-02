import java.util.Scanner;

/**
 * Problem 3: The Hostel Electricity Bill
 * Category C - Week 8 Assignment Problem
 *
 * Demonstrates polymorphic electricity billing across different room types:
 * - Single room: ₹8 per unit
 * - Shared room: ₹6 per unit, split equally among occupants
 * - AC room: ₹10 per unit + fixed charge of ₹200
 */
public class Problem3_HostelElectricityBill {

    public abstract static class HostelRoom {
        protected String roomType;
        protected int units;

        public HostelRoom(String roomType, int units) {
            this.roomType = roomType;
            this.units = units;
        }

        public String getRoomType() {
            return roomType;
        }

        public abstract double calculateBill();
    }

    public static class SingleRoom extends HostelRoom {
        public SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return units * 8.0;
        }
    }

    public static class SharedRoom extends HostelRoom {
        private int occupants;

        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = Math.max(1, occupants);
        }

        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    public static class ACRoom extends HostelRoom {
        public ACRoom(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            return (units * 10.0) + 200.0;
        }
    }

    public static void processRooms(HostelRoom[] rooms) {
        double grandTotal = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
            grandTotal += bill;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                HostelRoom[] rooms = new HostelRoom[n];
                for (int i = 0; i < n; i++) {
                    String type = scanner.next();
                    int units = scanner.nextInt();
                    if (type.equalsIgnoreCase("SHARED")) {
                        int occupants = scanner.nextInt();
                        rooms[i] = new SharedRoom(units, occupants);
                    } else if (type.equalsIgnoreCase("AC")) {
                        rooms[i] = new ACRoom(units);
                    } else {
                        rooms[i] = new SingleRoom(units);
                    }
                }
                processRooms(rooms);
            }
            scanner.close();
            return;
        }

        System.out.println("=== The Hostel Electricity Bill ===");
        HostelRoom[] sampleRooms = new HostelRoom[] {
            new SingleRoom(120),
            new SharedRoom(150, 3),
            new ACRoom(100)
        };
        processRooms(sampleRooms);
    }
}
