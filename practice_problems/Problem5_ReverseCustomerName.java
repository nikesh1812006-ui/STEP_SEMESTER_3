/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Reverses a customer name string without modifying the original input data.
 */
public class Problem5_ReverseCustomerName {

    /**
     * Reverses the given customer name using character traversal.
     * 
     * @param customerName The original name string
     * @return Reversed name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) return null;
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");
        String[] sampleNames = {"Sunil", "Alice", "John Doe", "A"};

        for (String name : sampleNames) {
            String reversed = reverseCustomerName(name);
            System.out.printf("Original Name: %s | Reversed Name: %s%n", name, reversed);
        }
    }
}
