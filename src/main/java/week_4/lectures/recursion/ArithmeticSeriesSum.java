package week_4.lectures.recursion;

public class ArithmeticSeriesSum {
    public final static String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "'n' must be a non-negative value.";

    /**
     * Calculates the sum of the first 'n' positive integers using a recursive approach.
     *
     * @param n The non-negative integer representing the number of terms in the series.
     * @return The sum of the first 'n' positive integers.
     * @throws IllegalArgumentException if the input integer is negative.
     * @implNote Time Complexity: o(n)
     */
    public int recursiveArithmeticSeriesSum(int n) {
        validateNonNegativeInputParameter(n);

        if (n == 0) return 0;
        return n + recursiveArithmeticSeriesSum(n - 1);
    }

    /**
     * Calculates the sum of the first 'n' positive integers using a linear approach.
     *
     * @param n The non-negative integer representing the number of terms in the series.
     * @return The sum of the first 'n' positive integers.
     * @throws IllegalArgumentException if the input integer is negative.
     * @implNote Time Complexity: o(n)
     */
    public int linearArithmeticSeriesSum(int n) {
        validateNonNegativeInputParameter(n);

        int sum = 0;
        while (n > 0) {
            sum += n--;
        }
        return sum;
    }

    /**
     * Validates that the input integer is non-negative.
     *
     * @param n The integer to be validated.
     * @throws IllegalArgumentException if the input integer is negative.
     */
    private void validateNonNegativeInputParameter(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
