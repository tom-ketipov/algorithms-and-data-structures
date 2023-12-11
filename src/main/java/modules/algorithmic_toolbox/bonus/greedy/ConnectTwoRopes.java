package modules.algorithmic_toolbox.bonus.greedy;

import java.util.Arrays;

import static services.ValidationService.*;

public class ConnectTwoRopes {
    public final static String NON_NULL_ROPES_EXCEPTION_MESSAGE = "The input array of ropes must not be null.";
    public final static String NON_EMPTY_ROPES_EXCEPTION_MESSAGE = "The input array of ropes must not be empty.";
    public final static String NON_NEGATIVE_ROPE_INDEX_EXCEPTION_MESSAGE = "The input array of ropes must contain only non-negative values.";

    /**
     * Connects two ropes and returns the total cost.
     *
     * @param ropes The input array of ropes.
     * @return The total cost of connecting the ropes.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public int connectRopes(int[] ropes) {
        validateNotNull(ropes, NON_NULL_ROPES_EXCEPTION_MESSAGE);
        validateNotEmpty(ropes, NON_EMPTY_ROPES_EXCEPTION_MESSAGE);
        validateArrayIndexesInRange(ropes, 0, Integer.MAX_VALUE, NON_NEGATIVE_ROPE_INDEX_EXCEPTION_MESSAGE);

        Arrays.sort(ropes);
        int end = ropes.length - 1, start = 0, price = 0;
        while (end >= start) {
            if (end == start) {
                price += ropes[end];
                break;
            }
            price += ropes[start++] + ropes[end--];
        }
        return price;
    }
}
