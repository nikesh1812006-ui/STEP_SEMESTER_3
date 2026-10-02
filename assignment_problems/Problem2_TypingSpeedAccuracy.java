/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 * Scenario: Online typing-practice assessment
 * 
 * Compares user typed text character-by-character against original text,
 * calculates accuracy percentage, and reports the position of the first mismatch.
 */
public class Problem2_TypingSpeedAccuracy {

    /**
     * Checks typing accuracy and first mismatch location.
     * 
     * @param original The expected passage
     * @param typed The text typed by the user
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int totalLen = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        int compareLen = Math.min(original.length(), typed.length());
        for (int i = 0; i < compareLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLen + 1;
        }

        double accuracy = (totalLen > 0) ? ((double) matched / totalLen) * 100.0 : 0.0;

        if (firstMismatchPos != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, totalLen, accuracy, firstMismatchPos, origChar, typedChar);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, totalLen, accuracy);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker ===");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
        checkTypingAccuracy("BridgeLabz", "BridgeLabs");
    }
}
