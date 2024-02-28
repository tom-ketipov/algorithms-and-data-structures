package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class ArithmeticSeriesSum {

    /**
     * Calculates the sum of the first 'n' positive integers using a recursive approach.
     *
     * @param n The non-negative integer representing the number of terms in the series.
     * @return The sum of the first 'n' positive integers.
     * @throws IllegalArgumentException if the input integer is negative.
     * @implNote Time Complexity: o(n)
     */
    public int recursiveArithmeticSeriesSum(int n) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, n, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, n, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int sum = 0;
        while (n > 0) {
            sum += n--;
        }
        return sum;
    }
}
