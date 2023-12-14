package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import static services.ValidationService.validateInRange;
import static services.ValidationService.validateNotNull;

public class MinMaxOfArray {

    public int recursiveMin(int[] array) {
        return recursiveMin(array, 0);
    }

    /**
     * Recursively finds the minimum value in the specified subarray.
     *
     * @param array The input integer array.
     * @param index The current index in the array.
     * @return The minimum value in the subarray.
     * @implNote Time Complexity: O(n)
     */
    private int recursiveMin(int[] array, int index) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInRange(index, 0, array.length - 1, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);

        if (index == array.length - 1) return array[index];
        return Math.min(array[index], recursiveMin(array, index + 1));
    }

    public int recursiveMax(int[] array) {
        return recursiveMax(array, 0);
    }

    /**
     * Recursively finds the maximum value in the specified subarray.
     *
     * @param array The input integer array.
     * @param index The current index in the array.
     * @return The maximum value in the subarray.
     * @implNote Time Complexity: O(n)
     */
    private int recursiveMax(int[] array, int index) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInRange(index, 0, array.length - 1, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);

        if (index == array.length - 1) return array[index];
        return Math.max(array[index], recursiveMax(array, index + 1));
    }

    /**
     * Iteratively finds the minimum value in the specified array.
     *
     * @param array The input integer array.
     * @return The minimum value in the array.
     */
    private int iterativeMin(int[] array) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }


    /**
     * Iteratively finds the maximum value in the specified array.
     *
     * @param array The input integer array.
     * @return The maximum value in the array.
     */
    private int iterativeMax(int[] array) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
}
