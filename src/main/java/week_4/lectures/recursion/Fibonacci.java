package week_4.lectures.recursion;

public class Fibonacci {
    public static final String NEGATIVE_INDEX_VALIDATION_ERROR_MESSAGE = "Index must be non-negative.";

    /**
     * Calculates the Fibonacci number at a given index using a recursive approach.
     *
     * @param index The index of the Fibonacci number to be calculated. Must be non-negative.
     * @return The Fibonacci number at the specified index.
     * @throws IllegalArgumentException if the index is negative.
     */
    public long recursiveFibonacci(int index) {
        validateNonNegativeIndex(index);

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
        validateNonNegativeIndex(index);

        long current = 0, previous = 1;
        while (index-- > 0) {
            long next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }

    /**
     * Validates that the provided index is non-negative.
     *
     * @param index The index to validate.
     * @throws IllegalArgumentException If the provided index is negative.
     */
    private void validateNonNegativeIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException(NEGATIVE_INDEX_VALIDATION_ERROR_MESSAGE);
        }
    }
}
