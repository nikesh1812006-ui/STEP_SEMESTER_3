import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 3: 3Sum
 * Scenario: Budgeting transaction reconciliation finding distinct zero-sum triplets
 * 
 * Finds all unique triplets [nums[i], nums[j], nums[k]] such that i != j != k and
 * nums[i] + nums[j] + nums[k] == 0, with systematic duplicate elimination.
 */
public class Problem3_ThreeSum {

    /**
     * Finds all distinct zero-sum triplets.
     * Runs in O(n^2) time after an O(n log n) initial sort.
     * 
     * @param nums Array of integers
     * @return 2D array of unique triplets
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early break if the smallest value is positive (sum cannot be zero)
            if (nums[i] > 0) break;

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    private static String formatTriplets(int[][] triplets) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < triplets.length; i++) {
            sb.append(Arrays.toString(triplets[i]));
            if (i < triplets.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== 3Sum ===");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.printf("nums = %s -> %s%n",
                Arrays.toString(nums1), formatTriplets(threeSum(nums1)));

        int[] nums2 = {0, 0, 0};
        System.out.printf("nums = %s -> %s%n",
                Arrays.toString(nums2), formatTriplets(threeSum(nums2)));

        int[] nums3 = {0, 1, 1};
        System.out.printf("nums = %s -> %s%n",
                Arrays.toString(nums3), formatTriplets(threeSum(nums3)));
    }
}
