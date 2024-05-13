package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import modules.core.BaseSolver;
import org.apache.commons.lang3.Validate;

public class SelectionSortSolver extends BaseSolver {

    /**
     * Sorts the given integer array in ascending order using selection sort algorithm.
     * This method modifies the original array.
     *
     * @param array the array to be sorted
     * @throws IllegalArgumentException if the input array is null
     */
    public void sort(int[] array) {
        Validate.notNull(array, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            if (array[i + 1] != array[i]) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[index] > array[j]) {
                        index = j;
                    }
                }

                if (index != i) swap(array, i, index);
            }
        }
    }
}
