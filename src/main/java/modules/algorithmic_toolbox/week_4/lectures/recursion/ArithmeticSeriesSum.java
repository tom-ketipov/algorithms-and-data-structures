package modules.algorithmic_toolbox.week_4.lectures.recursion;

import static services.ValidationService.validateInRange;

public class ArithmeticSeriesSum {
    public final static String NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "The input number must be non-negative value.";

    /**
     * Calculates the sum of the first 'n' positive integers using a recursive approach.
     *
     * @param n The non-negative integer representing the number of terms in the series.
     * @return The sum of the first 'n' positive integers.
     * @throws IllegalArgumentException if the input integer is negative.
     * @implNote Time Complexity: o(n)
     */
    public int recursiveArithmeticSeriesSum(int n) {
        validateInRange(n, 0, Integer.MAX_VALUE, NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateInRange(n, 0, Integer.MAX_VALUE, NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

        int sum = 0;
        while (n > 0) {
            sum += n--;
        }
        return sum;
    }
}
