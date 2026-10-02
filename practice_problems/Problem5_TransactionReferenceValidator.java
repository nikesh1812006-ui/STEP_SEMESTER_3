/**
 * Problem 5: Bank Transaction Reference Generator & Validator
 * Scenario: Fintech onboarding module reference code processing
 * 
 * Normalizes and validates 14-character reference codes:
 * 3 letters (bank code) + 6 digits (date: ddMMyy) + 5 digits (sequence number).
 */
public class Problem5_TransactionReferenceValidator {

    /**
     * Normalizes raw reference: trims whitespace and uppercases only the first 3 characters.
     * 
     * @param raw The raw input reference string
     * @return Normalized string
     */
    public static String normalizeReference(String raw) {
        if (raw == null) return null;
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized reference and constructs formatted display line or returns error message.
     * 
     * @param reference The normalized reference string
     * @return Formatted string "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345" or specific error reason
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 numeric digits";
            }
        }

        // Build formatted line: "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year).append(" | ");
        sb.append("SEQ: ").append(seq);

        return sb.toString();
    }

    public static void processReference(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nResult: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Transaction Reference Validator ===");
        processReference("  hdf03022600042  ");
        processReference("12F03022600042");
        processReference("sbi0302260001"); // short length
        processReference("icic03022600042"); // 4 letters
        processReference("bar0302260004X"); // non-digit body
    }
}
