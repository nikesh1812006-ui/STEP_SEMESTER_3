/**
 * Problem 4: Hackathon Seating Grid Optimizer
 * Scenario: Mentors identifying rows in need of assistance vs humming fine
 * 
 * Analyzes a 2D jagged grid of seating scores, utilizing a reusable helper rowAverage()
 * to classify rows into "Quiet Zone" (< threshold) or "Buzzing Zone" (>= threshold).
 */
public class Problem4_HackathonSeatingGridOptimizer {

    /**
     * Computes the mathematical average of an individual row.
     * 
     * @param row Array of scores for a single row
     * @return Double precision average, or 0.0 if row is empty
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        long sum = 0;
        for (int val : row) {
            sum += val;
        }

        return (double) sum / row.length;
    }

    /**
     * Classifies each row in the seating grid against a threshold.
     * 
     * @param seatingScores 2D array of rows (may have varying lengths)
     * @param threshold Cutoff average score
     * @return Formatted summary classification string
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            sb.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Hackathon Seating Grid Optimizer ===");
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String result = classifyRows(seating, threshold);
        System.out.println("Classification: " + result);
    }
}
