/**
 * Problem 4: Match Day Grid Analyzer
 * Scenario: Cricket stats app analyzing runs scored in each over of each match
 * 
 * Reuses a private helper rowAverage() once per match to determine whether
 * each match was a "Power Surge" (>= threshold) or "Normal" (< threshold).
 */
public class Problem4_MatchDayGridAnalyzer {

    /**
     * Computes the average runs per over for a single match row.
     * 
     * @param row Array of runs scored in each over of a match
     * @return Double precision average
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        long sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    /**
     * Classifies each match into Power Surge vs. Normal based on threshold scoring rate.
     * 
     * @param runsPerOver 2D jagged grid representing overs per match
     * @param threshold Cutoff average for a Power Surge
     * @return Formatted summary string
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            sb.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Match Day Grid Analyzer ===");
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        String analysis = classifyMatches(runs, threshold);
        System.out.println("Analysis: " + analysis);
    }
}
