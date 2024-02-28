package modules.algorithmic_toolbox.week_4.lectures.sort;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class InsertionSort {

    /**
     * Sorts the given integer array using the insertion sort algorithm.
     *
     * @param arr The integer array to be sorted. It must not be null.
     * @throws NullPointerException If the input array is null.
     *                              Time Complexity O(n^2)
     */
    public void insertionSort(int[] arr) {
        Validate.notNull(arr, ValidationMessageUtility.getMessage("not_null_array_exception"));

        for (int i = 1; i < arr.length; i++) {
            insert(arr, i);
        }
    }

    /**
     * Inserts the element at the specified index into its correct position in the sorted part of the array.
     *
     * @param arr   The integer array in which the insertion is performed. It must not be null.
     * @param index The index of the element to be inserted.
     * @throws NullPointerException     If the input array is null.
     * @throws IllegalArgumentException If the index is out of the array bounds.
     */
    private void insert(int[] arr, int index) {
        Validate.notNull(arr, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = arr.length - 1;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int comparableValue = arr[index], i;
        for (i = index - 1; i >= 0 && arr[i] > comparableValue; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = comparableValue;
    }

    /**
     * Sorts the given array in ascending order using Insertion Sort with
     * Binary Search for finding the insertion index.
     *
     * @param array The array to be sorted.
     * @implNote Time Complexity: 0(n^2)
     */
    public void sort(int[] array) {
        sort(array, 0);
    }

    /**
     * Recursive helper method for the sort operation. It inserts the element
     * at the correct position using Binary Search and continues the sorting process.
     *
     * @param array The array to be sorted.
     * @param index The current index being processed during the recursive sorting.
     * @throws NullPointerException     if array is null
     * @throws IllegalArgumentException if array index is out of bounds
     */
    private void sort(int[] array, int index) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = array.length;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        if (index == array.length) return;

        insertIndex(array, index);
        sort(array, index + 1);
    }


    /**
     * Finds the insertion index for the current element using Binary Search.
     * If the insertion index is different from the current index, it performs
     * the insertion by shifting elements accordingly.
     *
     * @param array The array to be sorted.
     * @param index The index of the current element to be inserted.
     * @throws NullPointerException     if array is null
     * @throws IllegalArgumentException if array index is out of bounds
     */
    private void insertIndex(int[] array, int index) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = array.length - 1;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int currentElement = array[index], insertionIndex = binarySearchInsertionIndex(array, index);
        if (insertionIndex != index) {
            System.arraycopy(array, insertionIndex, array, insertionIndex + 1, index - insertionIndex);
            array[insertionIndex] = currentElement;
        }
    }

    /**
     * Performs Binary Search to find the insertion index for the current element
     * in the given sorted portion of the array.
     *
     * @param array        The array to be sorted.
     * @param currentIndex The index of the current element to be inserted.
     * @return The insertion index for the current element.
     * @throws NullPointerException if array is null
     * @throws IllegalArgumentException if array index is out of bounds
     */
    private int binarySearchInsertionIndex(int[] array, int currentIndex) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = array.length - 1;
        Validate.inclusiveBetween(minValue, maxValue, currentIndex, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int startIndex = 0, endIndex = currentIndex, currentElement = array[currentIndex];
        while (startIndex <= endIndex) {
            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            if (array[midIndex] == currentElement) {
                return midIndex;
            } else if (array[midIndex] < currentElement) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return endIndex + 1;
    }
}
