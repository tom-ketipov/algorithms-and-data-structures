package modules.algorithmic_toolbox.week_1;

import services.ValidationMessages;

import java.util.Arrays;

import static services.ValidationService.validateNotEmpty;
import static services.ValidationService.validateNotNull;

public class MaximumPairwiseProduct {

    /**
     * Calculates the maximum pairwise product of an array of long integers.
     *
     * @param numbersArray The array of long integers for which to find the maximum pairwise product.
     * @return The maximum pairwise product of the two largest integers in the array.
     * @throws IllegalArgumentException if the input array is null or empty.
     */
    public long maxPairwiseProduct(long[] numbersArray) {
        validateNotNull(numbersArray, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(numbersArray, ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE);

        // sort the array of numbers
        Arrays.sort(numbersArray);

        return numbersArray.length >= 2 ?
                numbersArray[numbersArray.length - 1] * numbersArray[numbersArray.length - 2] :
                numbersArray[0];
    }
}
