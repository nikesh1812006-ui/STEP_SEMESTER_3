/**
 * Problem 3: Product Inventory CSV Parser
 * Scenario: Warehouse inventory updates CSV processing
 * 
 * Splits comma-separated values into Product, SKU, and Quantity fields,
 * validating field count and formatting output.
 */
public class Problem3_ProductInventoryCSVParser {

    /**
     * Parses a product inventory CSV line into formatted output or reports invalid record.
     * 
     * @param csvLine The raw record string in "ProductName,SKU,Quantity" format
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        if (product.isEmpty() || sku.isEmpty() || qty.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", product, sku, qty);
    }

    public static void main(String[] args) {
        System.out.println("=== Product Inventory CSV Parser ===");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
        parseInventoryRecord("Mechanical Keyboard,KB-9900,45");
        parseInventoryRecord(",,");
    }
}
