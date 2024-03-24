package modules.algorithmic_toolbox.week_4.assignments.search.linear;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class IterativeLinearSearchSolver {

    /**
     * Iteratively searches for a target integer in an array using linear search algorithm.
     *
     * @param target The integer to search for in the array.
     * @param array  The array in which to perform the search.
     * @return The index of the target integer if found; otherwise, -1.
     * @throws NullPointerException if the input array is null.
     */
    public int search(int target, int[] array) {
        Validate.notNull(array, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }
}
