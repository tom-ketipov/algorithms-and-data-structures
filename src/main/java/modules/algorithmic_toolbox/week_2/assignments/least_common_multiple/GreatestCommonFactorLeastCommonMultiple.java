package modules.algorithmic_toolbox.week_2.assignments.least_common_multiple;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.greatest_common_divisor.EuclideanGreatestCommonDivisor;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class GreatestCommonFactorLeastCommonMultiple {

    /**
     * Calculates the least common multiple (LCM) of two BigInteger numbers using the greatest common divisor (GCD).
     *
     * @param a the first non-zero, non-negative BigInteger.
     * @param b the second non-zero, non-negative BigInteger.
     * @return the LCM of a and b.
     * @throws NullPointerException     if a or b is null.
     * @throws IllegalArgumentException if a or b is null, zero, or negative.
     */
    public BigInteger findLCMWithGreatestCommonFactor(BigInteger a, BigInteger b) {
        Validate.notNull(a, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(b, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Validate.isTrue(!a.equals(BigInteger.ZERO) || a.compareTo(BigInteger.ZERO) < 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        Validate.isTrue(!b.equals(BigInteger.ZERO) || b.compareTo(BigInteger.ZERO) < 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        EuclideanGreatestCommonDivisor greatestCommonDivisorSolver = new EuclideanGreatestCommonDivisor();

        return (a.multiply(b)).divide(greatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }
}
