import java.util.Arrays;

/**
 * Problem 4: Merge Two Sorted Arrays
 * Scenario: Merging sorted examination score lists without re-sorting
 * 
 * Uses the two-pointer technique to combine two sorted integer arrays in O(m + n) time.
 */
public class Problem4_MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays into a single new sorted array.
     * 
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Fully merged, sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2 != null ? arr2.clone() : new int[]{};
        if (arr2 == null) return arr1.clone();

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Traverse both arrays comparing current elements
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1 if any
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 if any
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Merge Two Sorted Arrays ===");
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.printf("arr1 = %s, arr2 = %s -> %s%n",
                Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(mergeSortedArrays(arr1, arr2)));

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.printf("arr3 = %s, arr4 = %s -> %s%n",
                Arrays.toString(arr3), Arrays.toString(arr4), Arrays.toString(mergeSortedArrays(arr3, arr4)));
    }
}
