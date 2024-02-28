package modules.algorithmic_toolbox.week_1;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;

public class MaximumPairwiseProduct {

    /**
     * Calculates the maximum pairwise product of an array of long integers.
     *
     * @param numbersArray The array of long integers for which to find the maximum pairwise product.
     * @return The maximum pairwise product of the two largest integers in the array.
     * @throws IllegalArgumentException if the input array is empty.
     * @throws NullPointerException if the input array is null.
     */
    public long maxPairwiseProduct(long[] numbersArray) {
        Validate.notNull(numbersArray, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(numbersArray.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        // sort the array of numbers
        Arrays.sort(numbersArray);

        return numbersArray.length >= 2 ?
                numbersArray[numbersArray.length - 1] * numbersArray[numbersArray.length - 2] :
                numbersArray[0];
    }
}
