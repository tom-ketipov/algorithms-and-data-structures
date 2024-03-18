package modules.algorithmic_toolbox.week_2.assignments.prime;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class TrialDivisionPrimeNumberValidator {

    /**
     * Determines whether the provided integer is a prime number.
     * A prime number is a natural number greater than 1 that
     * has no positive divisors other than 1 and itself. This method
     * utilizes the square root approach for optimization, meaning
     * it checks divisibility up to the square root of n rather than n/2,
     * making it more efficient for large numbers.
     *
     * @param n the number to be checked for primality.
     * @return true if n is a prime number; false otherwise.
     * @throws IllegalArgumentException if n is less than or equal to 1,
     *                                  indicating the number is below the minimum threshold for prime evaluation.
     * @implNote Time complexity: O(sqrt(n))
     */
    public boolean isPrime(int n) {
        Validate.isTrue(n > 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2));

        int wall = (int) Math.sqrt(n);
        boolean isPrime = true;

        for (int i = 2; i <= wall; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
