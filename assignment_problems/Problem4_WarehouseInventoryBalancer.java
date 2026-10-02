/**
 * Problem 4: The Warehouse Inventory Balancer
 * Scenario: Retail warehouse multi-section inventory verification
 * 
 * Computes totals for two storage sections, assesses balance, and finds the highest quantity item.
 */
public class Problem4_WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across Section A and Section B.
     * 
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Invalid sections: inventory arrays must be non-null and equal length.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxIndex = -1; // 1-indexed for display

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQty, maxSection, maxIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer ===");
        int[] secA1 = {20, 15, 30};
        int[] secB1 = {25, 10, 30};
        analyzeInventory(secA1, secB1);

        int[] secA2 = {40, 20, 10};
        int[] secB2 = {30, 20, 15};
        analyzeInventory(secA2, secB2);
    }
}
