import java.util.Arrays;

/**
 * Problem 3: Top-3 Podium Finder
 * Scenario: Stage judge announcing top-3 podium finishers instantly without full sorting
 * 
 * Scans an array in a single pass O(n) to maintain the 3 highest scores (including ties)
 * and returns them in descending order.
 */
public class Problem3_TopThreePodiumFinder {

    /**
     * Finds the top 3 scores in a single pass without sorting.
     * 
     * @param scores Array of scores (length >= 3)
     * @return Array of top 3 scores in descending order: [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[]{};
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s > first) {
                third = second;
                second = first;
                first = s;
            } else if (s > second) {
                third = second;
                second = s;
            } else if (s > third) {
                third = s;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Top-3 Podium Finder ===");
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.printf("scores = %s -> %s%n",
                Arrays.toString(scores1), Arrays.toString(findTopThreeScores(scores1)));

        int[] scores2 = {10, 20, 30, 40, 50};
        System.out.printf("scores = %s -> %s%n",
                Arrays.toString(scores2), Arrays.toString(findTopThreeScores(scores2)));
    }
}
