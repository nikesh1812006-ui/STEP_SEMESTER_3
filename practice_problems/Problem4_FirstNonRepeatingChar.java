/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Computes frequency of every character and finds the first character with frequency 1.
 */
public class Problem4_FirstNonRepeatingChar {

    /**
     * Finds the first character with frequency exactly 1.
     * Returns '\0' if no such character exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency table for ASCII characters
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                freq[ch]++;
            }
        }

        // Left-to-right scan to find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void testAndDisplay(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.printf("Input: \"%s\" -> First Non-Repeating Character: '%c'%n", input, result);
        } else {
            System.out.printf("Input: \"%s\" -> No Non-Repeating Character Found%n", input);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        testAndDisplay("swiss");
        testAndDisplay("aabbcc");
        testAndDisplay("programming");
        testAndDisplay("step");
    }
}
