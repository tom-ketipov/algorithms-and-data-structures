package modules.algorithmic_toolbox.week_2.assignments.greatest_common_divisor.assignments.challanges;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

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
        Validate.notNull(a, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(b, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Validate.isTrue(a.equals(BigInteger.ZERO) || a.compareTo(BigInteger.ZERO) > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));
        Validate.isTrue(b.equals(BigInteger.ZERO) || b.compareTo(BigInteger.ZERO) > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger remainder = a.mod(b);
            a = b;
            b = remainder;
        }
        return a;
    }
}
