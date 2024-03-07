package modules.algorithmic_toolbox.week_2.least_common_multiple.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.greatest_common_divisor.assignments.challanges.EuclideanGreatestCommonDivisor;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class GreatestCommonFactorLeastCommonMultiple {

    public BigInteger findLCMWithGreatestCommonFactor(BigInteger a, BigInteger b) {
        Validate.notNull(a, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(b, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Validate.isTrue(!a.equals(BigInteger.ZERO) || a.compareTo(BigInteger.ZERO) < 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        Validate.isTrue(!b.equals(BigInteger.ZERO) || b.compareTo(BigInteger.ZERO) < 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        EuclideanGreatestCommonDivisor greatestCommonDivisorSolver = new EuclideanGreatestCommonDivisor();

        return (a.multiply(b)).divide(greatestCommonDivisorSolver.findEuclideanGCD(a, b));
    }
}
