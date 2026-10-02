/**
 * Problem 2: Word Reversal Encoder
 * Scenario: Coding club "mirror text" mini-game
 * 
 * Reverses each word in a sentence individually while maintaining the original word order.
 */
public class Problem2_WordReversalEncoder {

    /**
     * Reverses each word in the sentence using StringBuilder.
     * 
     * @param sentence Space-delimited sentence
     * @return Transformed sentence with reversed words
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) return null;
        if (sentence.trim().isEmpty()) return sentence;

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Word Reversal Encoder ===");
        String sample1 = "hello club";
        System.out.println("Input: \"" + sample1 + "\" -> Output: \"" + reverseEachWord(sample1) + "\"");

        String sample2 = "Java programming is fun";
        System.out.println("Input: \"" + sample2 + "\" -> Output: \"" + reverseEachWord(sample2) + "\"");
    }
}
