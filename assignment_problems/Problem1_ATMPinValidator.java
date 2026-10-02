/**
 * Problem 1: ATM PIN Length Validator
 * Scenario: ATM initial PIN security length check
 * 
 * Verifies that a PIN is exactly 4 digits using basic length checking and if/else.
 */
public class Problem1_ATMPinValidator {

    /**
     * Checks whether the PIN is exactly 4 digits long.
     * 
     * @param pin The entered PIN string
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM PIN Length Validator ===");
        System.out.print("\"482\" -> ");
        checkPinLength("482");

        System.out.print("\"4820\" -> ");
        checkPinLength("4820");

        System.out.print("\"12345\" -> ");
        checkPinLength("12345");
    }
}
