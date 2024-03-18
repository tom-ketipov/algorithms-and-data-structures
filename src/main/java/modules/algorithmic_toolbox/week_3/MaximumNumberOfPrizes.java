package modules.algorithmic_toolbox.week_3;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfPrizes {
    /**
     * Calculates the maximum number of distinct positive prizes that sum up to the totalSum.
     *
     * @param totalSum The total sum to be distributed as prizes. It should be between 1 and 1,000,000,000 inclusive.
     * @return The maximum number of distinct prizes that can be distributed without exceeding the total sum.
     * @throws IllegalArgumentException if the totalSum is outside the valid range.
     * @implNote Time complexity: O(√n) where n is the totalSum
     */
    public int calculateMaximumNumberOfPrizes(int totalSum) {
        Validate.inclusiveBetween(1, 1000000000, totalSum, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000000000));

        int nextPrize = 1;
        int totalCountOfPrizes = 1;
        while (totalSum > 0) {
            if (totalSum - nextPrize <= nextPrize) break;

            totalCountOfPrizes++;
            totalSum -= nextPrize;
            nextPrize++;
        }

        return totalCountOfPrizes;
    }

    /**
     * Calculates the distribution of distinct positive prizes that sum up to the totalSum.
     *
     * @param totalSum The total sum to be distributed as prizes, must be between 1 and 1,000,000,000 inclusive.
     * @return A list representing the distribution of distinct prizes that can be given out.
     * @throws IllegalArgumentException if the totalSum is outside the specified range.
     */
    public List<Integer> calculatePrizeDistribution(int totalSum) {
        Validate.inclusiveBetween(1, 1000000000, totalSum, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000000000));

        List<Integer> prizeDistribution = new ArrayList<>();

        int nextPrize = 1;
        while (totalSum > 0) {
            if (prizeDistribution.isEmpty() || totalSum - nextPrize > nextPrize) {
                prizeDistribution.add(nextPrize);
            } else {
                prizeDistribution.add(totalSum);
                break;
            }
            totalSum -= nextPrize;
            nextPrize++;
        }
        return prizeDistribution;
    }
}
