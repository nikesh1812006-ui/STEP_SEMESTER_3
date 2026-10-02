import java.util.Arrays;

/**
 * Problem 1: Fantasy Team Score Multiplier
 * Scenario: Fantasy sports app applying Captain (2x) and Vice-Captain (1.5x) multipliers
 * 
 * Modifies the original caller array directly via reference with a void return type.
 */
public class Problem1_FantasyTeamScoreMultiplier {

    /**
     * Applies score boosts directly to the original array.
     * 
     * @param playerScores Array of scores passed by reference
     * @param captainIndex Index of captain (doubled points: 2x)
     * @param viceCaptainIndex Index of vice-captain (1.5x points)
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Fantasy Team Score Multiplier ===");
        double[] scores = {40, 55, 30, 62};
        System.out.println("Original scores: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("Boosted scores:  " + Arrays.toString(scores));
    }
}
