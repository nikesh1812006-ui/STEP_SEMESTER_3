/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Verifies whether a string is a palindrome using 3 independent techniques:
 * 1. Iterative two-pointer comparison
 * 2. Recursive substring comparison
 * 3. Character array reversal and comparison
 */
public class Problem2_PalindromeChecker {

    /**
     * Approach 1: Iterative two-pointer check from outside inward.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check shrinking from edges toward base case.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, start + 1, end - 1);
    }

    /**
     * Approach 3: Character array reversal and equality check.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyAndPrint(String input) {
        boolean iter = isPalindromeIterative(input);
        boolean rec = isPalindromeRecursive(input);
        boolean arr = isPalindromeArrayReversal(input);

        String iterStr = iter ? "Palindrome" : "Not Palindrome";
        String recStr = rec ? "Palindrome" : "Not Palindrome";
        String arrStr = arr ? "Palindrome" : "Not Palindrome";

        System.out.printf("\"%s\" Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                input, iterStr, recStr, arrStr);
    }

    public static void main(String[] args) {
        System.out.println("=== QA Toolkit: Palindrome Multi-Approach Verification ===");
        verifyAndPrint("madam");
        verifyAndPrint("hello");
        verifyAndPrint("racecar");
        verifyAndPrint("step");
    }
}
