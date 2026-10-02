import java.util.*;

/**
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 * Scenario: T&P feedback text-mining tool
 * 
 * Cleans feedback text, excludes common filler words ("the", "was", "and", "a", "is", "of", "in"),
 * computes frequency counts for remaining meaningful words, and prints them sorted by count in descending order.
 */
public class Problem5_StopWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Filters stop words and prints word frequencies sorted in descending order.
     * 
     * @param feedback The input feedback paragraph
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: lowercase and strip punctuation (periods, commas, etc.)
        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace("!", "");
        cleaned = cleaned.replace("?", "");
        cleaned = cleaned.replace(";", "");
        cleaned = cleaned.replace(":", "");

        String[] words = cleaned.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            String trimmedWord = word.trim();
            if (!trimmedWord.isEmpty() && !STOP_WORDS.contains(trimmedWord)) {
                freqMap.put(trimmedWord, freqMap.getOrDefault(trimmedWord, 0) + 1);
            }
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report ===");
        String feedback = "The mentor was great, the session was great and clear.";
        System.out.println("Feedback: \"" + feedback + "\"\n");
        printFilteredWordFrequency(feedback);
    }
}
