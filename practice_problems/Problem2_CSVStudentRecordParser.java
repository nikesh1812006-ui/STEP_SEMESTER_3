/**
 * Problem 2: CSV Student Record Parser
 * Scenario: T&P team student registration data parser
 * 
 * Splits CSV lines into fields, validates that exactly 3 fields exist, and prints formatted output.
 */
public class Problem2_CSVStudentRecordParser {

    /**
     * Parses a student CSV line in the form "Name,RollNumber,Department".
     * Validates that exactly 3 fields are present; if not, prints "Invalid Record".
     * 
     * @param csvLine The raw comma-separated record
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        System.out.println("=== CSV Student Record Parser ===");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
        parseStudentRecord("Rohan Sharma,RA2211003010456,ECE");
        parseStudentRecord("Invalid,,Record");
    }
}
