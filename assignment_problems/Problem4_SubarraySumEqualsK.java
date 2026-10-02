import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4: Subarray Sum Equals K
 * Scenario: Hostel daily attendance-change log analyzing contiguous intervals summing to k
 * 
 * Computes the total number of continuous subarrays whose sum equals k using
 * running prefix sums combined with a hash map in O(n) time and O(n) space.
 */
public class Problem4_SubarraySumEqualsK {

    /**
     * Finds count of subarrays with sum equal to k.
     * 
     * @param nums Array of integers (may include negatives)
     * @param k Target sum
     * @return Number of subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores frequency of each prefix sum: prefixSum -> frequency
        Map<Integer, Integer> prefixMap = new HashMap<>();
        // Base case: prefix sum of 0 appears once before processing any elements
        prefixMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            // If (currentSum - k) exists in map, add its frequency
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Subarray Sum Equals K ===");
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.printf("nums = %s, k = %d -> %d%n",
                Arrays.toString(nums1), k1, subarraySum(nums1, k1));

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.printf("nums = %s, k = %d -> %d%n",
                Arrays.toString(nums2), k2, subarraySum(nums2, k2));

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        System.out.printf("nums = %s, k = %d -> %d%n",
                Arrays.toString(nums3), k3, subarraySum(nums3, k3));
    }
}
