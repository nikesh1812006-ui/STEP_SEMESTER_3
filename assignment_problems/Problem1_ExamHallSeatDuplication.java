/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: The Examination Cell Seating Allocation
 * 
 * Scans an array of assigned seat numbers to flag any duplicates without using Collections.
 */
public class Problem1_ExamHallSeatDuplication {

    /**
     * Checks for duplicate seat numbers using only arrays and loops.
     * 
     * @param seatNumbers Array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats provided.");
            return;
        }

        boolean foundAnyDuplicate = false;
        // Track indices already reported as duplicates to avoid multiple prints
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }
            boolean isDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                foundAnyDuplicate = true;
            }
        }

        if (!foundAnyDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1: Array with duplicates ===");
        int[] hallA = {101, 102, 103, 102, 105};
        checkDuplicateSeats(hallA);

        System.out.println("\n=== Test Case 2: Array without duplicates ===");
        int[] hallB = {101, 102, 103, 104, 105};
        checkDuplicateSeats(hallB);
    }
}
