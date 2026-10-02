/**
 * Problem 4: The Locker Code
 * Category C - Week 7 Practice Problem
 *
 * Requirements:
 * - The combination code must be private, with no getter at all.
 * - Provide a method to change the code that requires the current code to be entered correctly first.
 * - If the wrong current code is given, the change must be rejected and the code must stay the same.
 * - Give the locker a final locker number, fixed at creation.
 */
public class Problem4_TheLockerCode {

    public static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.code = initialCode;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (this.code.equals(currentCode)) {
                this.code = newCode;
                System.out.println("Locker " + lockerNumber + ": Code successfully changed.");
                return true;
            } else {
                System.out.println("Locker " + lockerNumber + ": Incorrect current code. Code change rejected.");
                return false;
            }
        }

        public boolean unlock(String enteredCode) {
            return this.code.equals(enteredCode);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Locker Code ===");
        Locker l = new Locker(101, "1234");
        System.out.println("Locker Number: " + l.getLockerNumber());

        boolean res1 = l.changeCode("1234", "5678");
        System.out.println("Change 1 (1234 -> 5678) result: " + (res1 ? "success" : "rejected"));

        boolean res2 = l.changeCode("0000", "9999");
        System.out.println("Change 2 (0000 -> 9999) result: " + (res2 ? "success" : "rejected"));

        System.out.println("Unlock with 5678: " + l.unlock("5678"));
        System.out.println("Unlock with 1234: " + l.unlock("1234"));
    }
}
