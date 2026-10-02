/**
 * Problem 3: Course Credit Management
 * Scenario: Academic curriculum course registration with optional lab credit
 * 
 * Demonstrates constructor overloading and delegation using this(...) chaining.
 */
public class Problem3_CourseCreditManagement {

    public static class Course {
        private String code;
        private String title;
        private int credits;
        private int labCredits;

        // Master 4-argument constructor
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Chained 3-argument constructor for theory-only courses
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Course Credit Management ===");
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}
