package modules.algorithmic_toolbox.week_2.least_common_multiple.assignments.challanges;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

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
        Validate.isTrue(a != 0, ValidationMessageUtility.getMessage("zero_value_exception"));
        Validate.isTrue(b != 0, ValidationMessageUtility.getMessage("zero_value_exception"));

        // Convert a and b to their absolute values to ensure positive multiples
        BigInteger absA = BigInteger.valueOf(Math.abs(a));
        BigInteger absB = BigInteger.valueOf(Math.abs(b));
        BigInteger multipleA = absA;

        while (!multipleA.mod(absB).equals(BigInteger.ZERO)) {
            multipleA = multipleA.add(absA);
        }
        return multipleA;
    }
}
