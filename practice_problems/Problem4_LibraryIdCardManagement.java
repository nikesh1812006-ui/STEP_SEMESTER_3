/**
 * Problem 4: Library ID Card Management
 * Scenario: Reference aliasing versus independent heap instances
 * 
 * Demonstrates reference assignment (shallow aliasing) versus distinct heap objects
 * using identity comparison (==).
 */
public class Problem4_LibraryIdCardManagement {

    public static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Library ID Card Reference Management ===");
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // Points to the exact same object in memory

        // Mutating via duplicate affects the object pointed to by ravi
        duplicate.booksIssued = 3;

        // Separate object created with identical fields
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
