package modules.algorithmic_toolbox.week_4.lectures.sort;

import services.ValidationMessages;

import static services.ValidationService.validateInArrayBounds;
import static services.ValidationService.validateNotNull;

public class InsertionSort {

    /**
     * Sorts the given integer array using the insertion sort algorithm.
     *
     * @param arr The integer array to be sorted. It must not be null.
     * @throws IllegalArgumentException If the input array is null.
     *                                  Time Complexity O(n^2)
     */
    public void insertionSort(int[] arr) {
        validateNotNull(arr, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);

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
        validateNotNull(arr, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInArrayBounds(arr, index, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);

        int comparableValue = arr[index], i;
        for (i = index - 1; i >= 0 && arr[i] > comparableValue; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = comparableValue;
    }
}
