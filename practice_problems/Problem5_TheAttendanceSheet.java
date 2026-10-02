/**
 * Problem 5: The Attendance Sheet
 * Category C - Week 7 Practice Problem
 *
 * Requirements:
 * - Store the names of present students in a private array (fixed size is fine — assume a maximum class size).
 * - Provide a method to mark a student present.
 * - Provide a method that returns how many students are present, and another that checks whether one specific name is present.
 * - There should be no method that returns the whole array of names.
 * - Marking "Ana", "Ben", and "Ana" again present results in a count of 2 (no duplicates).
 */
public class Problem5_TheAttendanceSheet {

    public static class AttendanceSheet {
        private final String[] presentStudents;
        private int count;

        public AttendanceSheet(int maxClassSize) {
            this.presentStudents = new String[maxClassSize];
            this.count = 0;
        }

        public boolean markPresent(String studentName) {
            if (studentName == null || studentName.trim().isEmpty()) {
                return false;
            }
            if (isPresent(studentName)) {
                // Already marked present, ignore duplicate
                return false;
            }
            if (count >= presentStudents.length) {
                System.out.println("Attendance sheet is full. Cannot mark " + studentName);
                return false;
            }
            presentStudents[count++] = studentName.trim();
            return true;
        }

        public int getPresentCount() {
            return count;
        }

        public boolean isPresent(String studentName) {
            if (studentName == null) return false;
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equalsIgnoreCase(studentName.trim())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Attendance Sheet ===");
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
