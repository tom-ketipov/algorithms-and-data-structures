package modules.algorithmic_toolbox.week_4.lectures.sort;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;

public class MergeSort {

    /**
     * Sorts an array of integers in ascending order using the Merge Sort algorithm.
     * The array is recursively divided into halves, sorted individually, and then merged.
     *
     * @param array The array of integers to be sorted.
     * @throws NullPointerException for null input values
     */
    public void mergeSort(int[] array) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        if (array.length <= 1) return;

        int midIndex = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, midIndex);
        int[] right = Arrays.copyOfRange(array, midIndex, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    /**
     * Merges two sorted arrays into left single sorted array.
     *
     * @param array The target array where the merged result will be stored.
     * @param left  The first sorted array to be merged.
     * @param right The second sorted array to be merged.
     */
    private void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, i = 0;
        while (left.length > leftIndex && right.length > rightIndex) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[i] = left[leftIndex++];
            } else {
                array[i] = right[rightIndex++];
            }
            i++;
        }

        while (left.length > leftIndex) {
            array[i++] = left[leftIndex++];
        }

        while (right.length > rightIndex) {
            array[i++] = right[rightIndex++];
        }
    }
}