package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class Fibonacci {
    /**
     * Calculates the Fibonacci number at a given index using a recursive approach.
     *
     * @param index The index of the Fibonacci number to be calculated. Must be non-negative.
     * @return The Fibonacci number at the specified index.
     * @throws IllegalArgumentException if the index is negative.
     */
    public long recursiveFibonacci(int index) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        // Base cases
        if (index == 0) {
            return 0;
        } else if (index == 1 || index == 2) {
            return 1;
        }
        return recursiveFibonacci(index - 1) + recursiveFibonacci(index - 2);
    }

    /**
     * Calculates the Fibonacci number at the specified index using a linear algorithm.
     *
     * @param index The index of the Fibonacci number to calculate. Must be non-negative.
     * @return The Fibonacci number at the specified index.
     * @throws IllegalArgumentException If the provided index is negative.
     */
    public long linearFibonacci(int index) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, index, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        long current = 0, previous = 1;
        while (index-- > 0) {
            long next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }
}
