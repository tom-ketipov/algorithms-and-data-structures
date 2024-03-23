package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;
import java.util.Arrays;

/*
        3.2.7 Largest Concatenate Problem
        Compile the largest integer by concatenating the given integers.
 */
public class MaximumSalaryConstructor {
    /**
     * Constructs the largest possible number by rearranging the given array of non-negative digits.
     *
     * @param digits An array of non-negative integers representing digits.
     * @return A BigInteger representing the largest possible number formed by the digits.
     * @throws NullPointerException     If the digits array is null.
     * @throws IllegalArgumentException If any digit in the array is negative.
     */
    public BigInteger constructLargestNumber(int[] digits) {
        Validate.notNull(digits, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        // Ensure no negative digits
        boolean hasNoNegativeDigits = Arrays.stream(digits)
                .allMatch(digit -> digit >= 0);
        Validate.isTrue(hasNoNegativeDigits, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        String[] asStrings = Arrays.stream(digits)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort strings according to custom logic
        Arrays.sort(asStrings, (a, b) -> (b + a).compareTo(a + b));

        return new BigInteger(String.join("", asStrings));
    }
}
