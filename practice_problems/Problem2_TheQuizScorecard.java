/**
 * Problem 2: The Quiz Scorecard
 * Category C - Week 7 Practice Problem
 *
 * Requirements:
 * - Store the results (true for correct, false for incorrect) in a private array, filled in one answer at a time.
 * - Provide a method to record the next answer's result.
 * - Expose only the total score (count of correct answers) — never the array itself, in any form.
 * - The total number of questions must be fixed when the scorecard is created.
 */
public class Problem2_TheQuizScorecard {

    public static class Scorecard {
        private final int totalQuestions;
        private final boolean[] answers;
        private int recordedCount;

        public Scorecard(int totalQuestions) {
            this.totalQuestions = totalQuestions;
            this.answers = new boolean[totalQuestions];
            this.recordedCount = 0;
        }

        public boolean recordAnswer(boolean isCorrect) {
            if (recordedCount >= totalQuestions) {
                System.out.println("All questions have already been answered. Cannot record more.");
                return false;
            }
            answers[recordedCount++] = isCorrect;
            return true;
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < recordedCount; i++) {
                if (answers[i]) {
                    score++;
                }
            }
            return score;
        }

        public int getTotalQuestions() {
            return totalQuestions;
        }

        public int getRecordedCount() {
            return recordedCount;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Quiz Scorecard ===");
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Total Score: " + sc.getScore());
    }
}
