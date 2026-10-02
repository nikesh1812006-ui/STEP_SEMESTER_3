/**
 * Problem 3: The Password Checker
 * Category C - Week 7 Assignment Problem
 *
 * Requirements:
 * - Take the password as a string in the constructor and store it privately, with no getter that returns it.
 * - Provide a method that returns a strength label:
 *   - "Weak" (under 6 characters)
 *   - "Medium" (6-9 characters)
 *   - "Strong" (10+ characters)
 * - The password itself must never be changeable after creation.
 * - Password itself is never exposed.
 */
public class Problem3_ThePasswordChecker {

    public static final class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = (password != null) ? password : "";
        }

        public String getStrength() {
            int len = password.length();
            if (len < 6) {
                return "Weak";
            } else if (len <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Password Checker ===");
        PasswordChecker pc1 = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        PasswordChecker pc3 = new PasswordChecker("abcdefghij");

        System.out.println("pc1 (4 chars)  -> " + pc1.getStrength());
        System.out.println("pc2 (8 chars)  -> " + pc2.getStrength());
        System.out.println("pc3 (10 chars) -> " + pc3.getStrength());
    }
}
