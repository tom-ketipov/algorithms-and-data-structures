package modules.algorithmic_toolbox.week_2.assignments.greatest_common_divisor.assignments.challanges;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class NaiveGreatestCommonDivisor {

    /**
     * Calculates the greatest common divisor (GCD) of two non-negative integers using a naive approach.
     * This method sequentially checks each integer from the maximum of 'a' and 'b' downwards until it finds
     * the highest integer that divides both 'a' and 'b' without leaving a remainder.
     *
     * @param a The first non-negative integer to find the GCD for.
     * @param b The second non-negative integer to find the GCD for.
     * @return The greatest common divisor of 'a' and 'b'.
     * @throws IllegalArgumentException if either 'a' or 'b' is negative.
     * @implNote Time complexity: O(n), where n is equal to the smaller number between a and b
     */
    public int naiveGCDFinder(int a, int b) {
        Validate.isTrue(a >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));
        Validate.isTrue(b >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        if (a == 0) return b;
        if (b == 0) return a;

        int gcd = Math.min(a, b);
        while (a % gcd != 0 || b % gcd != 0) {
            gcd--;
        }
        return gcd;
    }
}
