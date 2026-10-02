/**
 * Problem 4: The Traffic Light
 * Category C - Week 7 Assignment Problem
 *
 * Requirements:
 * - Current color must be private, changed only by next() method that moves RED -> GREEN -> YELLOW -> RED.
 * - No method that sets color directly to any arbitrary value.
 * - Provide a read-only way to check current color: getColor().
 * - Final ID, fixed when created.
 * - A new light starts on RED.
 */
public class Problem4_TheTrafficLight {

    public static class TrafficLight {
        private final String id;
        private String color;

        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED"; // Initial state
        }

        public String getId() {
            return id;
        }

        public String getColor() {
            return color;
        }

        public String next() {
            switch (color) {
                case "RED":
                    color = "GREEN";
                    break;
                case "GREEN":
                    color = "YELLOW";
                    break;
                case "YELLOW":
                    color = "RED";
                    break;
                default:
                    color = "RED";
                    break;
            }
            return color;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Traffic Light ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light ID: " + t.getId());
        System.out.println("Initial color: " + t.getColor());
        System.out.println("Next: " + t.next());
        System.out.println("Next: " + t.next());
        System.out.println("Next: " + t.next());
        System.out.println("Next: " + t.next());
    }
}
