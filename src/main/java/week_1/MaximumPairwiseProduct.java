package week_1;

import core.BaseSolver;

import java.util.Arrays;

public class MaximumPairwiseProduct extends BaseSolver {
    public long maxPairwiseProduct(long[] numbersArray) {
        validate(numbersArray);

        // sort the array of numbers
        Arrays.sort(numbersArray);
        return numbersArray.length >= 2 ? numbersArray[numbersArray.length - 1] * numbersArray[numbersArray.length - 2] : numbersArray[0];
    }
}
