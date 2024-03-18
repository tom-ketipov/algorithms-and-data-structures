package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

/*
    Maximum Product of Two Sequences Problem
    Find the maximum dot product of two sequences of numbers.

    Input: Two sequences of n positive integers: price1 , . . . , price n and clicks1 , . . . , clicks n .
    Output: The maximum value of price1 · c1 + · · · + price n · cn , where c1 , . . . , cn is a permutation of clicks1 , . . . , clicks n .
 */
public class MaximumAdvertisementRevenue {

    /**
     * Calculates the maximum advertisement revenue based on the number of available slots, bid prices, and click rates.
     *
     * @param numAdSlots the number of available advertisement slots. Must be between 1 and 1000.
     * @param bidPrices  an array of bid prices for the advertisement slots. Cannot be null and must have at least 'numAdSlots' elements.
     * @param clickRates an array of click rates associated with each advertisement slot. Cannot be null and must be of the same length as 'bidPrices'.
     * @return the maximum total revenue that can be generated from the given advertisement slots, bid prices, and click rates.
     * @throws IllegalArgumentException if any input parameters do not meet their specified constraints or are invalid.
     * @throws NullPointerException     if either 'bidPrices' or 'clickRates' is null.
     * @implNote Time complexity: O(n log n)
     */
    public long calculateMaxAdvertisementRevenue(int numAdSlots, int[] bidPrices, int[] clickRates) {
        Validate.inclusiveBetween(1, 1000, numAdSlots, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000));
        Validate.notNull(bidPrices, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(clickRates, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(clickRates.length == bidPrices.length);
        Validate.isTrue(bidPrices.length >= numAdSlots);

        // Sort the arrays to maximize revenue
        Arrays.sort(bidPrices);
        Arrays.sort(clickRates);

        // Calculate the total revenue
        long totalRevenue = 0;
        for (int i = bidPrices.length - 1; i >= bidPrices.length - numAdSlots; i--) {
            totalRevenue += (long) bidPrices[i] * clickRates[i];
        }
        return totalRevenue;
    }
}
