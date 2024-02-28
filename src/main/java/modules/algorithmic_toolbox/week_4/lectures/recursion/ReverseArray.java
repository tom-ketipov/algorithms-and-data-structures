package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class ReverseArray {
    /**
     * Reverses an array of integers using a recursive approach.
     *
     * @param arr The integer array to be reversed. Must not be null.
     * @return The reversed integer array.
     * @throws IllegalArgumentException if the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int[] recursiveArrayReverse(int[] arr) {
        return recursiveArrayReverseInRange(arr, 0, arr.length - 1);
    }

    /**
     * Reverses a range of elements in an array of integers using a recursive approach.
     *
     * @param arr   The integer array in which elements are to be reversed. Must not be null.
     * @param left  The left index of the range to be reversed.
     * @param right The right index of the range to be reversed.
     * @return The integer array with the specified range reversed.
     * @throws NullPointerException if the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int[] recursiveArrayReverseInRange(int[] arr, int left, int right) {
        Validate.notNull(arr, ValidationMessageUtility.getMessage("not_null_array_exception"));

        if (left >= right) return arr;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        return recursiveArrayReverseInRange(arr, left + 1, right - 1);
    }

    /**
     * Reverses an array of integers using a linear approach.
     *
     * @param arr The integer array to be reversed. Must not be null.
     * @return The reversed integer array.
     * @throws NullPointerException if the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int[] linerArrayReverse(int[] arr) {
        Validate.notNull(arr, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int temp = arr[left];

            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return arr;
    }
}
