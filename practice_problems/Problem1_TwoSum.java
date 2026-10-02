import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1: Two Sum
 * Scenario: Supermarket billing counter scanning item pairs matching budget
 * 
 * Given an integer array nums and an integer target, returns indices of the two numbers
 * such that they add up to target.
 */
public class Problem1_TwoSum {

    /**
     * Finds indices of the two elements that sum up to target.
     * Uses HashMap for optimal O(n) time complexity.
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return Array of two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== Two Sum ===");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums1), target1, Arrays.toString(twoSum(nums1, target1)));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums2), target2, Arrays.toString(twoSum(nums2, target2)));
    }
}
