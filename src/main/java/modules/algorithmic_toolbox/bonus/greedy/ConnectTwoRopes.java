package modules.algorithmic_toolbox.bonus.greedy;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

import java.util.Arrays;

public class ConnectTwoRopes {
    /**
     * Connects two ropes and returns the total cost.
     *
     * @param ropes The input array of ropes.
     * @return The total cost of connecting the ropes.
     * @throws IllegalArgumentException if the input array is empty.
     * @throws NullPointerException     if the input array is null.
     */
    public int connectRopes(int[] ropes) {
        Validate.notNull(ropes, ValidationMessageUtility.getMessage("not_null_array_exception"));
        Validate.isTrue(ropes.length > 0, ValidationMessageUtility.getMessage("not_empty_array_exception"));

        int minValue = 1;
        int maxValue = Integer.MAX_VALUE;
        for (int rope : ropes) {
            Validate.inclusiveBetween(minValue, maxValue, rope, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));
        }

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
