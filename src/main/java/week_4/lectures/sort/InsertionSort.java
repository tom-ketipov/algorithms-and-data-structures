package week_4.lectures.sort;

public class InsertionSort {

    /**
     * Sorts the given integer array using the insertion sort algorithm.
     *
     * @param arr The integer array to be sorted. It must not be null.
     * @throws IllegalArgumentException If the input array is null.
     *                                  Time Complexity O(n^2)
     */
    public void insertionSort(int[] arr) {
        validateInputArray(arr);

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
        validateInputArray(arr);
        validateIndex(arr, index);

        int comparableValue = arr[index], i;
        for (i = index - 1; i >= 0 && arr[i] > comparableValue; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = comparableValue;
    }

    /**
     * Validates that the input array is not null.
     *
     * @param arr The integer array to be validated.
     * @throws IllegalArgumentException If the input array is null.
     */
    private void validateInputArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
    }

    /**
     * Validates that the index is within the array bounds.
     *
     * @param arr   The integer array.
     * @param index The index to be validated.
     * @throws IllegalArgumentException If the index is out of the array bounds.
     */
    private void validateIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Index value must be inside array borders.");
        }
    }
}
