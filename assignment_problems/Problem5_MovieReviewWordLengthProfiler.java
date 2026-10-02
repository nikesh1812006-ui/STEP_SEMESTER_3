/**
 * Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie-review platform content moderation & spam filter
 * 
 * Profiles the lengths of words in a review into:
 * - Short (1-4 letters)
 * - Medium (5-8 letters)
 * - Long (9+ letters)
 */
public class Problem5_MovieReviewWordLengthProfiler {

    /**
     * Classifies words in a review string into Short, Medium, and Long buckets.
     * 
     * @param review The review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by whitespace
        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip out surrounding punctuation if any, or measure word length
            String clean = word.replaceAll("[^a-zA-Z]", "");
            int len = clean.isEmpty() ? word.length() : clean.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler ===");
        String sample1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + sample1 + "\"");
        classifyWordLengths(sample1);

        String sample2 = "A masterpiece of cinematic storytelling and visual wonder";
        System.out.println("\nReview: \"" + sample2 + "\"");
        classifyWordLengths(sample2);
    }
}
