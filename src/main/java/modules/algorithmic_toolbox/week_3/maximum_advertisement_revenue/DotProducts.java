package modules.algorithmic_toolbox.week_3.maximum_advertisement_revenue;

import services.ValidationMessages;

import java.util.Arrays;

import static services.ValidationService.validateNotEmpty;
import static services.ValidationService.validateNotNull;

public class DotProducts {
    /*
            Problem: The Maximum Product of Two Sequences Problem (e.g Maximum Advertisement Revenue)
            We have n advertising slots that we want to sell to advertisers.
            Each slot gets a different number of clicks and each advertiser is willing to pay a different amount.
            How do you pair the advertiser with the slot to maximize you click-revenue?

            Problem: Find the maximum dot product of two sequences of numbers.
            Inputs:	Two sequences of n positive integers.
            Output:	The maximum sum of pair-wise multiplications of the values.
            ================================================================================================
            Time complexity: O(n log n)
     */
    public long maxDotProduct(int[] prices, int[] clicks) {
        validateNotNull(prices, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotNull(clicks, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(prices, ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(clicks, ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE);

        Arrays.sort(prices);
        Arrays.sort(clicks);
        long result = 0;
        for (int i = 0; i < prices.length; i++) {
            result += (long) prices[i] * (long) clicks[i];
        }
        return result;
    }
}
