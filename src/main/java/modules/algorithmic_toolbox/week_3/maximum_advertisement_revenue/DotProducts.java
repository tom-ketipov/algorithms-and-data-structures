package modules.algorithmic_toolbox.week_3.maximum_advertisement_revenue;

import java.util.Arrays;

import static services.ValidationService.validateNotEmpty;
import static services.ValidationService.validateNotNull;

public class DotProducts {
    public final static String NON_NULL_PRICES_EXCEPTION_MESSAGE = "The input array of prices must not be null.";
    public final static String NON_EMPTY_PRICES_EXCEPTION_MESSAGE = "The input array of prices must not be empty.";
    public final static String NON_NULL_CLICKS_EXCEPTION_MESSAGE = "The input array of clicks must not be null.";
    public final static String NON_EMPTY_CLICKS_EXCEPTION_MESSAGE = "The input array of clicks must not be empty.";

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
        validateNotNull(prices, NON_NULL_PRICES_EXCEPTION_MESSAGE);
        validateNotNull(clicks, NON_NULL_CLICKS_EXCEPTION_MESSAGE);
        validateNotEmpty(prices, NON_EMPTY_PRICES_EXCEPTION_MESSAGE);
        validateNotEmpty(clicks, NON_EMPTY_CLICKS_EXCEPTION_MESSAGE);

        Arrays.sort(prices);
        Arrays.sort(clicks);
        long result = 0;
        for (int i = 0; i < prices.length; i++) {
            result += (long) prices[i] * (long) clicks[i];
        }
        return result;
    }
}
