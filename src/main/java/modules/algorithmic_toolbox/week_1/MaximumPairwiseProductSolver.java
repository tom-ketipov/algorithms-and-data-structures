package modules.algorithmic_toolbox.week_1;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;
import java.util.Arrays;

/*
        1.2 Maximum Pairwise Product Problem
        Find the maximum product of two distinct numbers in a sequence of non-negative integers.
 */
public class MaximumPairwiseProductSolver {

    /**
     * Calculates the maximum pairwise product of an array of long integers.
     *
     * @param numbersArray The array of long integers for which to find the maximum pairwise product.
     * @return The maximum pairwise product of the two largest integers in the array.
     * @throws NullPointerException     if the input array is null.
     * @throws IllegalArgumentException if the input array is empty.
     * @implNote time complexity: O(n log n)
     */
    public BigInteger findMaxPairwiseProduct(long[] numbersArray) {
        Validate.notNull(numbersArray, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(numbersArray.length > 0, ValidationMessageType.EMPTY_ARRAY_ERROR.getMessage());

        // sort the array of numbers
        Arrays.sort(numbersArray);

        return numbersArray.length >= 2 ?
                BigInteger.valueOf(numbersArray[numbersArray.length - 1]).multiply(BigInteger.valueOf(numbersArray[numbersArray.length - 2])) :
                BigInteger.valueOf(numbersArray[0]);
    }
}
