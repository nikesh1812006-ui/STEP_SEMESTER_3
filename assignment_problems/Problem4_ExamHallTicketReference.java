/**
 * Problem 4: Exam Hall Ticket Reference Management
 * Scenario: Proving shallow reference aliasing vs. independent heap objects
 *
 * Creates a HallTicket for "Priya", assigns a second variable pointing at the SAME object,
 * mutates via the alias, then creates a genuinely separate object and compares identity (==).
 */
public class Problem4_ExamHallTicketReference {

    public static class HallTicket {
        String studentName;
        int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exam Hall Ticket Reference Management ===");

        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;       // Alias – same heap object
        copy.seatNumber = 45;          // Mutation visible through both references

        HallTicket separate = new HallTicket("Priya", 45); // New heap object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
