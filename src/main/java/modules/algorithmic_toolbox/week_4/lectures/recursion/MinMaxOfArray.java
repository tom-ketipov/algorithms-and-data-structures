package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

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
     * @throws NullPointerException if input array is null
     * @implNote Time Complexity: O(n)
     */
    private int recursiveMin(int[] array, int index) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = array.length - 1;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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
     * @throws NullPointerException if input array is null
     * @implNote Time Complexity: O(n)
     */
    private int recursiveMax(int[] array, int index) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int minValue = 0;
        int maxValue = array.length - 1;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

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
     * @throws NullPointerException if input array is null
     */
    private int iterativeMax(int[] array) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
}
