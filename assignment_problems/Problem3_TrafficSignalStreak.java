/**
 * Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City traffic control signal malfunction diagnostics
 * 
 * Scans a day's signal log ('R', 'Y', 'G') to find the longest continuous streak of the same color.
 */
public class Problem3_TrafficSignalStreak {

    /**
     * Identifies the color and length of the longest continuous streak in the signal log.
     * 
     * @param signalLog String sequence of signal readings
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = c;
                currentStreak = 1;
            }
        }

        // Final check after loop completes
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("=== Traffic Signal Streak Analyzer ===");
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
        findLongestStreak("GGGGGG");
        findLongestStreak("RYG");
    }
}
