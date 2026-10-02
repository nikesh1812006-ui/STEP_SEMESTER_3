import java.util.Arrays;

/**
 * Problem 1: Hackathon Score Curve Booster
 * Scenario: Judging panel applying in-place score curve bonus
 * 
 * Demonstrates pass-by-reference semantics in Java: modifying elements directly
 * inside the caller's array without creating a new array or returning any value.
 */
public class Problem1_ScoreCurveBooster {

    /**
     * Curves scores in place by adding bonus to every element.
     * 
     * @param scores The original array passed by reference
     * @param bonus The flat bonus amount to add
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus <= 0) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Hackathon Score Curve Booster ===");
        int[] scores = {70, 85, 60};
        System.out.println("Original scores: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("Curved scores:   " + Arrays.toString(scores));
    }
}
