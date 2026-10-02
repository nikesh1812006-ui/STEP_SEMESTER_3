import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3: Contains Duplicate
 * Scenario: Roll number duplication verification before finalizing exam seating
 * 
 * Determines whether any value appears at least twice in an integer array.
 */
public class Problem3_ContainsDuplicate {

    /**
     * Checks if the array contains duplicate elements.
     * Uses HashSet for O(n) time complexity and early exit.
     * 
     * @param nums Array of integers
     * @return true if any element is repeated; false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Contains Duplicate ===");
        int[] nums1 = {1, 2, 3, 1};
        System.out.printf("nums = %s -> %b%n", Arrays.toString(nums1), containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.printf("nums = %s -> %b%n", Arrays.toString(nums2), containsDuplicate(nums2));

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.printf("nums = %s -> %b%n", Arrays.toString(nums3), containsDuplicate(nums3));
    }
}
