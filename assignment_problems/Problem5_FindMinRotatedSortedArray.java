import java.util.Arrays;

/**
 * Problem 5: Find Minimum in Rotated Sorted Array
 * Scenario: Circular duty roster earliest date identification
 * 
 * Locates the minimum element in an ascending sorted array that has been rotated at an unknown pivot,
 * running in O(log n) time using modified binary search.
 */
public class Problem5_FindMinRotatedSortedArray {

    /**
     * Finds the minimum element using binary search.
     * 
     * @param nums Array of unique integers rotated at some pivot
     * @return The minimum element in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // If array is not rotated (or rotated by full length)
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is strictly greater than right element, minimum must be in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is at mid or in left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== Find Minimum in Rotated Sorted Array ===");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.printf("nums = %s -> Min: %d%n", Arrays.toString(nums1), findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.printf("nums = %s -> Min: %d%n", Arrays.toString(nums2), findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.printf("nums = %s -> Min: %d%n", Arrays.toString(nums3), findMin(nums3));
    }
}
