package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

public class MergeSortSolver {

    /**
     * Sorts the input array using the merge sort algorithm.
     *
     * @param arr the array to be sorted
     * @throws NullPointerException if arr is null
     * @implNote time complexity: O(n log n)
     */
    public void sort(int[] arr) {
        Validate.notNull(arr, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        sort(left);
        sort(right);

        merge(left, right, arr);
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param left  the first sorted array to merge
     * @param right the second sorted array to merge
     * @param array the array to store the merged result
     * @implNote time complexity: O(n)
     */
    private void merge(int[] left, int[] right, int[] array) {
        int currentIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                array[currentIndex++] = left[leftIndex++];
            } else {
                array[currentIndex++] = right[rightIndex++];
            }
        }

        // Copy remaining elements from arrays 'a' and 'b'
        if (leftIndex < left.length) {
            System.arraycopy(left, leftIndex, array, currentIndex, left.length - leftIndex);
        }

        if (rightIndex < right.length) {
            System.arraycopy(right, rightIndex, array, currentIndex, right.length - rightIndex);
        }
    }
}
