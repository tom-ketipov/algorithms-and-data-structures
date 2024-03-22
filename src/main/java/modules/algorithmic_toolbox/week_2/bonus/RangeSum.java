package modules.algorithmic_toolbox.week_2.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        2.3.2 Range Sum Queries Problem
        Given an integer array and a set of ranges in it, compute the sum for each range.
 */
public class RangeSum {

    /**
     * Calculates the sum of elements within specified ranges of an array.
     *
     * @param nums         The array of integers for which the range sums are to be calculated.
     * @param rangeQueries An array of integer arrays, each consisting of two elements:
     *                     the start and end indices (inclusive) for the range query.
     * @return An array of integers where each element corresponds to the sum of the elements
     * within the range specified by the corresponding element in the rangeQueries array.
     * If nums or rangeQueries are empty, returns an array of zeros with the same length
     * as rangeQueries.
     * @throws NullPointerException     If either nums or rangeQueries (or any element of rangeQueries) is null.
     * @throws IllegalArgumentException If any range query is out of bounds of the nums array
     *                                  or does not contain exactly two elements.
     */
    public int[] rangeSum(int[] nums, int[][] rangeQueries) {
        Validate.notNull(nums, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(rangeQueries, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        int[] totalRangeSums = new int[rangeQueries.length];

        if (nums.length == 0 || rangeQueries.length == 0) return totalRangeSums;

        int[] prefixSums = calculatePrefixSums(nums);

        for (int i = 0; i < rangeQueries.length; i++) {
            Validate.notNull(rangeQueries[i], ValidationMessageType.NULL_VALUE_ERROR.getMessage());
            Validate.inclusiveBetween(0, nums.length - 1, rangeQueries[i][0], ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, nums.length - 1));
            Validate.inclusiveBetween(0, nums.length - 1, rangeQueries[i][1], ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(0, nums.length - 1));

            totalRangeSums[i] += prefixSums[rangeQueries[i][1]] - (rangeQueries[i][0] > 0 ? prefixSums[rangeQueries[i][0] - 1] : 0);
        }
        return totalRangeSums;
    }

    /**
     * Computes and returns the prefix sums of the input array. Each element in the returned array
     * represents the sum of all elements from the start of the input array up to the corresponding index.
     *
     * @param nums The input array of integers, not null, for which to compute the prefix sums.
     * @return An array of integers representing the prefix sums of the input array.
     */
    private int[] calculatePrefixSums(int[] nums) {
        int[] prefixSums = new int[nums.length];
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            prefixSums[i] = cumulativeSum;
        }
        return prefixSums;
    }
}
