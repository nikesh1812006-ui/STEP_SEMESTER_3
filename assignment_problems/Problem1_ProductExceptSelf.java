import java.util.Arrays;

/**
 * Problem 1: Product of Array Except Self
 * Scenario: Pricing engine bundle calculation
 * 
 * Computes product of all other elements for each index in O(n) time without division,
 * utilizing prefix products and running suffix accumulation.
 */
public class Problem1_ProductExceptSelf {

    /**
     * Calculates the product of array except self for each element.
     * 
     * @param nums Array of integers
     * @return Result array where result[i] is the product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: Prefix products stored directly in result
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: Running suffix product multiplied in-place
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Product of Array Except Self ===");
        int[] nums1 = {1, 2, 3, 4};
        System.out.printf("nums = %s -> %s%n",
                Arrays.toString(nums1), Arrays.toString(productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.printf("nums = %s -> %s%n",
                Arrays.toString(nums2), Arrays.toString(productExceptSelf(nums2)));
    }
}
