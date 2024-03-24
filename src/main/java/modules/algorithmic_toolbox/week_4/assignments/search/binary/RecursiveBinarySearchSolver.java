package modules.algorithmic_toolbox.week_4.assignments.search.binary;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class RecursiveBinarySearchSolver {

    /**
     * Recursively searches for a target value within a sorted array using binary search algorithm.
     *
     * @param target the value to search for
     * @param array  the sorted array in which to search
     * @return the index of the target value if found; otherwise, returns -1
     * @throws NullPointerException if the array is null
     */
    public int search(int target, int[] array) {
        Validate.notNull(array, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        return search(target, array, 0, array.length - 1);
    }

    /**
     * Helper method for the recursive binary search.
     *
     * @param target    the value to search for
     * @param array     the sorted array in which to search
     * @param lowIndex  the lowest index of the sub-array
     * @param highIndex the highest index of the sub-array
     * @return the index of the target value if found; otherwise, returns -1
     */
    private int search(int target, int[] array, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) return -1;

        int midIndex = lowIndex + (highIndex - lowIndex) / 2;

        if (array[midIndex] == target) return midIndex;

        if (array[midIndex] > target) {
            return search(target, array, lowIndex, midIndex - 1);
        } else {
            return search(target, array, midIndex + 1, highIndex);
        }
    }
}
