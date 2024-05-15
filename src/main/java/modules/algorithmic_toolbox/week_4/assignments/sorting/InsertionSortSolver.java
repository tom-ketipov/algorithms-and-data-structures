package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class InsertionSortSolver {

    /**
     * Sorts an integer array in non-decreasing order using the Insertion Sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public void sort(int[] arr) {
        Validate.notNull(arr, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}