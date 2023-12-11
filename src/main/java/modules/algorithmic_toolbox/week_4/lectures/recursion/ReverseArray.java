package modules.algorithmic_toolbox.week_4.lectures.recursion;

import static services.ValidationService.validateNotNull;

public class ReverseArray {
    public final static String NON_NULL_ARRAY_EXCEPTION_MESSAGE = "The input array must not be null.";

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
     * @throws IllegalArgumentException if the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int[] recursiveArrayReverseInRange(int[] arr, int left, int right) {
        validateNotNull(arr, NON_NULL_ARRAY_EXCEPTION_MESSAGE);

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
     * @throws IllegalArgumentException if the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int[] linerArrayReverse(int[] arr) {
        validateNotNull(arr, NON_NULL_ARRAY_EXCEPTION_MESSAGE);

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
