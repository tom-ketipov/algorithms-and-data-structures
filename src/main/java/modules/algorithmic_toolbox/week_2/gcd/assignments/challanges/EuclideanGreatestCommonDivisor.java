package modules.algorithmic_toolbox.week_2.gcd.assignments.challanges;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.math.BigInteger;
import java.util.Objects;

public class EuclideanGreatestCommonDivisor {

    /**
     * Calculates and returns the greatest common divisor (GCD) of two numbers using the Euclidean algorithm.
     *
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor (GCD) of a and b
     * @throws IllegalArgumentException if either a or b is null
     * @implNote Time complexity: Average O(log(min(a, b)))
     */
    public BigInteger findEuclideanGCD(BigInteger a, BigInteger b) {
        Validate.notNull(a, ValidationMessageUtility.getMessage("not_null_object_exception"));
        Validate.notNull(b, ValidationMessageUtility.getMessage("not_null_object_exception"));

        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger remainder = a.mod(b);
            a = b;
            b = remainder;
        }
        return a;
    }
}
