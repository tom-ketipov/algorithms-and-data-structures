package modules.algorithmic_toolbox.week_4.assignments.sorting.quick_sort;

import enums.ValidationMessageType;
import modules.core.BaseSolver;
import org.apache.commons.lang3.Validate;


public class LeftMostPivotQuickSortSolver extends BaseSolver {

    public void sort(int[] arr) {
        Validate.notNull(arr, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Recursively sorts the specified range of the array using the quicksort algorithm.
     *
     * @param arr   the array to be sorted
     * @param left  the left index of the range to be sorted
     * @param right the right index of the range to be sorted
     * @implNote time complexity: O(n log n) on average, O(n^2) worst case.
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int m = partition(arr, left, right);

        sort(arr, left, m - 1);
        sort(arr, m + 1, right);
    }

    /**
     * Partitions the array based on the pivot element.
     * Elements smaller than or equal to the pivot are moved to the left side,
     * and elements larger than the pivot are moved to the right side.
     *
     * @param arr   the array to be partitioned
     * @param left  the left index of the partition
     * @param right the right index of the partition
     * @return the index of the pivot element after partitioning
     */
    private int partition(int[] arr, int left, int right) {
        int pivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= arr[pivotIndex]) {
                left++;
                swap(arr, left, i);
            }
        }

        swap(arr, pivotIndex, left);
        return left;
    }
}
