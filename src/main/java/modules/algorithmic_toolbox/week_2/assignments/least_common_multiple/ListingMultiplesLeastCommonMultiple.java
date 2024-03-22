package modules.algorithmic_toolbox.week_2.assignments.least_common_multiple;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class ListingMultiplesLeastCommonMultiple {

    /**
     * Computes the least common multiple (LCM) of two values using listing multiples approach.
     *
     * @param a the first number
     * @param b the second number
     * @return the LCM of 'a' and 'b'.
     * @throws IllegalArgumentException if 'a' or 'b' is null.
     */
    public BigInteger findLCMWithListingMultiples(int a, int b) {
        Validate.isTrue(a > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        Validate.isTrue(b > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        BigInteger multipleA = BigInteger.valueOf(a);

        while (!multipleA.mod(BigInteger.valueOf(b)).equals(BigInteger.ZERO)) {
            multipleA = multipleA.add(BigInteger.valueOf(a));
        }
        return multipleA;
    }
}
