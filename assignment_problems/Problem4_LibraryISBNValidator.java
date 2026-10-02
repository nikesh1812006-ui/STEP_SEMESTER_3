/**
 * Problem 4: Library ISBN Normalizer & Validator
 * Scenario: Library book-intake scanner code normalization and verification
 * 
 * Normalizes and validates 13-character ISBN-style codes:
 * 3 letters (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class Problem4_LibraryISBNValidator {

    /**
     * Normalizes raw code: trims whitespace and uppercases only the first 3 characters.
     * 
     * @param raw Raw input string with possible surrounding whitespace
     * @return Normalized code string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) return null;
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized code and produces formatted display line or error reason.
     * 
     * @param code The normalized code string
     * @return Formatted string "[PUBCODE] YEAR: 20XX | CATALOG: 123456" or specific error reason
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body (year and catalog must be numeric)";
            }
        }

        // Build formatted display line: "[PUBCODE] YEAR: 20XX | CATALOG: 123456"
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | ");
        sb.append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void processCode(String raw) {
        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nResult: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Library ISBN Normalizer & Validator ===");
        processCode("  pen2026004251  ");
        processCode("12N2026004251");
        processCode("ore20240012");
        processCode("mac202500045A");
    }
}
