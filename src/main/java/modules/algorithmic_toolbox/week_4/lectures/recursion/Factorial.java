package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class Factorial {
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
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, n, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, n, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int factorial = 1, i = n;
        while (i > 1) {
            factorial *= i;
            i--;
        }
        return factorial;
    }
}
