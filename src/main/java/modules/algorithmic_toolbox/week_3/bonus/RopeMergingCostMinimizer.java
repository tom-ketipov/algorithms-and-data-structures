package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

/*
        3.3.6 Connect Ropes with Minimal Cost Problem
        Find the minimum cost of connecting n ropes into one where the cost of connecting two ropes is the sum of their lengths.
 */
public class RopeMergingCostMinimizer {

    /**
     * Connects multiple ropes with varying lengths into a single rope with minimal total cost.
     *
     * @param lengths An array of integers representing the lengths of different ropes.
     *                The array must not be null and must contain at least one positive integer.
     * @return The minimum total cost of connecting all ropes into one. Each connection cost
     * is defined as the sum of lengths of the two ropes being connected.
     * @throws NullPointerException     if the lengths array is null.
     * @throws IllegalArgumentException if the lengths array is empty or contains values less than or equal to 0.
     * @implNote Time Complexity O(n log n)
     */
    public int minimizeMergingCost(int[] lengths) {
        // Check if the array is not null and has at least one element
        Validate.notNull(lengths, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(lengths.length >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        Arrays.sort(lengths);

        // Ensure the smallest rope length is greater than zero
        Validate.isTrue(lengths[0] >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        // Return the length if there is only one rope
        if (lengths.length == 1) return lengths[0];

        int totalConnectionCost = 0;
        int currentRopeLength = lengths[0];
        for (int i = 1; i < lengths.length; i++) {
            currentRopeLength += lengths[i];
            totalConnectionCost += currentRopeLength;
        }

        return totalConnectionCost;
    }
}
