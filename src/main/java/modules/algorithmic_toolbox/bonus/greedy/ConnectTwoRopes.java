package modules.algorithmic_toolbox.bonus.greedy;

import services.ValidationMessages;

import java.util.Arrays;

import static services.ValidationService.*;

public class ConnectTwoRopes {
    /**
     * Connects two ropes and returns the total cost.
     *
     * @param ropes The input array of ropes.
     * @return The total cost of connecting the ropes.
     * @throws IllegalArgumentException If the input array is null or empty.
     */
    public int connectRopes(int[] ropes) {
        validateNotNull(ropes, ValidationMessages.NON_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateNotEmpty(ropes, ValidationMessages.NON_EMPTY_ARRAY_EXCEPTION_MESSAGE);
        validateArrayIndexesInRange(ropes, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
