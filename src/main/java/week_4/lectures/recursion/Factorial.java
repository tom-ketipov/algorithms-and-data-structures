package week_4.lectures.recursion;

public class Factorial {
    public final static String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "'n' must me non-negative number.";

    /**
     * Calculates the factorial of a non-negative integer using a recursive approach.
     * <p>
     * This method computes the factorial of a non-negative integer 'n' by recursively
     * multiplying 'n' with the factorial of 'n-1' until reaching the base case of n=0.
     *
     * @param n The non-negative integer for which the factorial is to be calculated.
     * @return The factorial of the given non-negative integer 'n'.
     * @throws IllegalArgumentException if 'n' is a negative number.
     */
    public int recursiveFactorial(int n) {
        validateNonNegative(n);

        if (n == 0) return 1;
        return n * recursiveFactorial(n - 1);
    }

    /**
     * Calculates the factorial of a non-negative integer using a linear approach.
     * <p>
     * This method computes the factorial of a non-negative integer 'n' by iteratively
     * multiplying all integers from 'n' down to 1.
     *
     * @param n The non-negative integer for which the factorial is to be calculated.
     * @return The factorial of the given non-negative integer 'n'.
     * @throws IllegalArgumentException if 'n' is a negative number.
     */
    public int linearFactorial(int n) {
        validateNonNegative(n);

        int factorial = 1, i = n;
        while (i > 1) {
            factorial *= i;
            i--;
        }
        return factorial;
    }

    /**
     * Validates that the given integer 'n' is non-negative.
     *
     * @param n The integer to be validated.
     * @throws IllegalArgumentException if 'n' is a negative number.
     */
    private void validateNonNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
