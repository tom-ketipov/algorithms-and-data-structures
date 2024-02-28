package modules.algorithmic_toolbox.week_3.maximum_advertisement_revenue;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

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
        Validate.notNull(prices, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(prices.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Validate.notNull(clicks, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(clicks.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        Arrays.sort(prices);
        Arrays.sort(clicks);
        long result = 0;
        for (int i = 0; i < prices.length; i++) {
            result += (long) prices[i] * (long) clicks[i];
        }
        return result;
    }
}
