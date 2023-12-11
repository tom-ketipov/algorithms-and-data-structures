package modules.algorithmic_toolbox.week_4.lectures.sort;

import static services.ValidationService.validateInArrayBounds;
import static services.ValidationService.validateNotNull;

public class InsertionSort {
    public final static String NON_NULL_ARRAY_EXCEPTION_MESSAGE = "The input array must not be null.";
    public final static String NON_IN_BOUNDS_ARRAY_INDEX_EXCEPTION_MESSAGE = "The input array index is out of bounds.";

    /**
     * Sorts the given integer array using the insertion sort algorithm.
     *
     * @param arr The integer array to be sorted. It must not be null.
     * @throws IllegalArgumentException If the input array is null.
     *                                  Time Complexity O(n^2)
     */
    public void insertionSort(int[] arr) {
        validateNotNull(arr, NON_NULL_ARRAY_EXCEPTION_MESSAGE);

        for (int i = 1; i < arr.length; i++) {
            insert(arr, i);
        }
    }

    /**
     * Inserts the element at the specified index into its correct position in the sorted part of the array.
     *
     * @param arr   The integer array in which the insertion is performed. It must not be null.
     * @param index The index of the element to be inserted.
     * @throws IllegalArgumentException If the input array is null.
     * @throws IllegalArgumentException If the index is out of the array bounds.
     */
    private void insert(int[] arr, int index) {
        validateNotNull(arr, NON_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInArrayBounds(arr, index, NON_IN_BOUNDS_ARRAY_INDEX_EXCEPTION_MESSAGE);

        int comparableValue = arr[index], i;
        for (i = index - 1; i >= 0 && arr[i] > comparableValue; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = comparableValue;
    }
}
