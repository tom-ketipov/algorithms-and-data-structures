package week_3.maximum_advertisement_revenue;

import java.security.InvalidParameterException;
import java.util.Arrays;

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
        // Validate input parameters
        if (prices == null || clicks == null) {
            throw new InvalidParameterException("Input array parameters cannot be null.");
        }

        if (prices.length == 0 || clicks.length == 0) {
            throw new InvalidParameterException("Input array parameters cannot be empty.");
    }

        Arrays.sort(prices);
        Arrays.sort(clicks);

        long result = 0;
        for (int i = 0; i < prices.length; i++) {
            result += (long) prices[i] * (long) clicks[i];
        }
        return result;
    }
}
