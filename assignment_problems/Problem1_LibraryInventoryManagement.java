/**
 * Problem 1: Library Inventory Management
 * Scenario: Library book inventory migration to OOP architecture
 * 
 * Replaces parallel arrays (titles, authors, copiesAvailable) with a cohesive BookInventory class.
 */
public class Problem1_LibraryInventoryManagement {

    public static class BookInventory {
        private String title;
        private String author;
        private int copiesAvailable;

        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printEntry() {
            System.out.printf("%s by %s - %d copies available%n", title, author, copiesAvailable);
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getCopiesAvailable() {
            return copiesAvailable;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Library Inventory Management ===");
        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
