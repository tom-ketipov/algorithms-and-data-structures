package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import modules.core.BaseSolver;
import org.apache.commons.lang3.Validate;

public class BubbleSortSolver extends BaseSolver {

    /**
     * Sorts an integer array in non-decreasing order using the Bubble Sort algorithm.
     *
     * @param arr the array to be sorted
     * @throws NullPointerException if the input array is null
     * @implNote time complexity: O(n^2)
     */
    public void sort(int[] arr) {
        Validate.notNull(arr, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        for (int i = arr.length - 1; i >= 0; i--) {
            int currentPosition = 0;
            while (currentPosition < i) {
                if (arr[currentPosition] > arr[currentPosition + 1]) {
                    swap(arr, currentPosition, currentPosition + 1);
                }
                currentPosition++;
            }
        }
    }
}
