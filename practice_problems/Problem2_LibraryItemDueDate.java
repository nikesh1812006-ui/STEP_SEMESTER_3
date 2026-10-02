import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Problem 2: Library Item Due Date Calculator
 * Category C - Week 8 Practice Problem
 *
 * Demonstrates inheritance and polymorphism across library items with different
 * borrowing durations (Book: 14 days, DVD: 7 days, Magazine: 3 days).
 */
public class Problem2_LibraryItemDueDate {

    public abstract static class LibraryItem {
        protected String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public abstract int getBorrowingDays();

        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(getBorrowingDays());
        }
    }

    public static class Book extends LibraryItem {
        public Book(String title) {
            super(title);
        }

        @Override
        public int getBorrowingDays() {
            return 14;
        }
    }

    public static class DVD extends LibraryItem {
        public DVD(String title) {
            super(title);
        }

        @Override
        public int getBorrowingDays() {
            return 7;
        }
    }

    public static class Magazine extends LibraryItem {
        public Magazine(String title) {
            super(title);
        }

        @Override
        public int getBorrowingDays() {
            return 3;
        }
    }

    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void displayDueDates(LibraryItem[] items, LocalDate currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.printf("%s: %s%n", item.getTitle(), dueDate.format(formatter));
        }
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.parse("2023-10-26");

        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int n = Integer.parseInt(scanner.nextLine().trim());
                LibraryItem[] items = new LibraryItem[n];
                for (int i = 0; i < n; i++) {
                    String line = scanner.nextLine().trim();
                    int firstSpace = line.indexOf(' ');
                    String type = line.substring(0, firstSpace);
                    String rawTitle = line.substring(firstSpace + 1).trim();
                    if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"")) {
                        rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
                    }
                    items[i] = createItem(type, rawTitle);
                }
                displayDueDates(items, currentDate);
            }
            scanner.close();
            return;
        }

        System.out.println("=== Library Item Due Date Calculator ===");
        LibraryItem[] sampleItems = new LibraryItem[] {
            createItem("BOOK", "1984"),
            createItem("DVD", "The Matrix"),
            createItem("MAGAZINE", "Forbes Issue 500")
        };
        displayDueDates(sampleItems, currentDate);
    }
}
