/**
 * Problem 5: Student and College Information Management
 * Scenario: Shared institutional metadata and instance counting
 * 
 * Replaces redundant per-instance college name copies with a shared static field
 * and tracks creation count via a static counter and static method.
 */
public class Problem5_StudentCollegeInfoManagement {

    public static class Student {
        private String name;
        private int attendance;

        // Shared across all instances
        private static String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++; // Increments on every object instantiation
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }

        public String getName() {
            return name;
        }

        public int getAttendance() {
            return attendance;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Student and College Information Management ===");
        Student s1 = new Student("Pooja", 85);
        Student s2 = new Student("Vignesh", 92);

        // Invoked via Class Name, not object reference
        Student.printCollegeInfo();
    }
}
