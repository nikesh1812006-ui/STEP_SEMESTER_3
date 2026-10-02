/**
 * Problem 1: Student Placement Record Management
 * Scenario: T&P cell migrating from out-of-sync parallel arrays to OOP classes
 * 
 * Replaces parallel arrays (names, companies, packages) with a structured PlacementRecord class.
 */
public class Problem1_PlacementRecordManagement {

    public static class PlacementRecord {
        private String studentName;
        private String company;
        private double packageLpa;

        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.printf("%s -> %s @ %.1f LPA%n", studentName, company, packageLpa);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Student Placement Record Management ===");
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
