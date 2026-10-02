import java.util.Arrays;

/**
 * Problem 2: Maximum Subarray
 * Scenario: Consecutive transaction/performance streak analysis
 * 
 * Finds the contiguous subarray with the largest sum using Kadane's Algorithm
 * in O(n) time and O(1) extra space. Correctly handles all-negative arrays.
 */
public class Problem2_MaximumSubarray {

    /**
     * Determines maximum subarray sum using Kadane's algorithm.
     * 
     * @param nums Array of integers
     * @return Maximum contiguous subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend existing subarray or start fresh from current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println("=== Maximum Subarray (Kadane's Algorithm) ===");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.printf("nums = %s -> Max Subarray Sum: %d%n",
                Arrays.toString(nums1), maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.printf("nums = %s -> Max Subarray Sum: %d%n",
                Arrays.toString(nums2), maxSubArray(nums2));

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.printf("nums = %s -> Max Subarray Sum: %d%n",
                Arrays.toString(nums3), maxSubArray(nums3));
    }
}
