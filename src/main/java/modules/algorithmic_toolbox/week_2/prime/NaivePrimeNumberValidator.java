package modules.algorithmic_toolbox.week_2.prime;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class NaivePrimeNumberValidator {

    /**
     * Determines whether the provided integer is a prime number.
     * A prime number is a natural number greater than 1 that
     * has no positive divisors other than 1 and itself.
     *
     * @param n the number to be checked for primality.
     * @return if n is a prime number
     * @throws IllegalArgumentException if n is less than or equal to 1.
     */
    public boolean isPrime(int n) {
        Validate.isTrue(n > 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2));

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
