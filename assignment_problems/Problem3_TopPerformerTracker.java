import java.util.Arrays;

/**
 * Problem 3: Top Performer Tracker
 * Scenario: Fantasy league weekly recap tracking standout and lowest performers
 * 
 * Determines minimum, maximum, and score spread in a single traversal O(n)
 * without sorting the underlying array.
 */
public class Problem3_TopPerformerTracker {

    /**
     * Finds min, max, and spread in a single pass.
     * 
     * @param scores Array of scores (length >= 2)
     * @return Formatted string: "Min: <min> | Max: <max> | Spread: <spread>"
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            return "Invalid score array";
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, spread);
    }

    public static void main(String[] args) {
        System.out.println("=== Top Performer Tracker ===");
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Result: " + findMinMaxSpread(scores));
    }
}
