import java.util.Arrays;

/**
 * Problem 5: Rotate Array
 * Scenario: Queue/playlist circular rotation to the right by k positions
 * 
 * Computes destination indices using modulo arithmetic: (i + k) % n.
 */
public class Problem5_RotateArray {

    /**
     * Rotates an integer array to the right by k steps.
     * 
     * @param nums Original integer array
     * @param k Number of positions to rotate
     * @return New rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n; // Handle negative rotation if passed
        }

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("=== Rotate Array ===");
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.printf("nums = %s, k = %d -> %s%n",
                Arrays.toString(nums1), k1, Arrays.toString(rotateArray(nums1, k1)));

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.printf("nums = %s, k = %d -> %s%n",
                Arrays.toString(nums2), k2, Arrays.toString(rotateArray(nums2, k2)));
    }
}
