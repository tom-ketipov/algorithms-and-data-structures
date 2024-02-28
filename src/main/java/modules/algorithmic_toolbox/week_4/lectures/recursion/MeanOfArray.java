package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class MeanOfArray {

    /**
     * Calculates the mean of the elements in an array using a recursive approach.
     *
     * @param array The input array of integers.
     * @param index The current index during recursive calculation.
     * @return The mean of the array elements.
     * @throws NullPointerException If the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int recursiveMeanOfArray(int[] array, int index) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        if (array.length == index) return 0;

        int sumOfRest = recursiveMeanOfArray(array, index + 1);
        int total = array[index] + sumOfRest;

        // Return the mean after all recursive calls are complete
        return index == 0 ? total / array.length : total;
    }

    /**
     * Calculates the mean of the elements in an array using a linear approach.
     *
     * @param array The input array of integers.
     * @return The mean of the array elements.
     * @throws NullPointerException If the input array is null.
     * @implNote Time Complexity: O(n)
     */
    public int linearMeanOfArray(int[] array) {
        Validate.notNull(array, ValidationMessageUtility.getMessage("not_null_array_exception"));

        int sum = 0;
        if (array.length == 0) return sum;

        for (int indexValue : array) {
            sum += indexValue;
        }
        return sum / array.length;
    }
}
