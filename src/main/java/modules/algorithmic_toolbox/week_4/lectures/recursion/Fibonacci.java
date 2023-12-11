package modules.algorithmic_toolbox.week_4.lectures.recursion;

import static services.ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static services.ValidationService.validateInRange;

public class Fibonacci {
    /**
     * Calculates the Fibonacci number at a given index using a recursive approach.
     *
     * @param index The index of the Fibonacci number to be calculated. Must be non-negative.
     * @return The Fibonacci number at the specified index.
     * @throws IllegalArgumentException if the index is negative.
     */
    public long recursiveFibonacci(int index) {
        validateInRange(index, 0, Integer.MAX_VALUE, NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateInRange(index, 0, Integer.MAX_VALUE, NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

        long current = 0, previous = 1;
        while (index-- > 0) {
            long next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }
}
