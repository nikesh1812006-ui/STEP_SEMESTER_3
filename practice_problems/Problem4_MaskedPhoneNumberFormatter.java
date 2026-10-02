/**
 * Problem 4: Masked Phone Number Formatter
 * Scenario: Student-support call center customer privacy display
 * 
 * Validates a 10-digit numeric phone number, builds a masked format showing
 * "XXXXXX" followed by a hyphen and the last 4 digits using StringBuilder.
 */
public class Problem4_MaskedPhoneNumberFormatter {

    /**
     * Formats a phone number to XXXXXX-last4 or returns error message.
     * 
     * @param phone The input phone number string
     * @return Formatted masked string or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Masked Phone Number Formatter ===");
        String[] samplePhones = {
            "9876543210",
            "98765",
            "987654321012",
            "987654abcd"
        };

        for (String phone : samplePhones) {
            System.out.printf("\"%s\" -> %s%n", phone, maskPhoneNumber(phone));
        }
    }
}
