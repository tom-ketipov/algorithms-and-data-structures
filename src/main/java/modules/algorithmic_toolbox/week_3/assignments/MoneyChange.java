package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        Money Change Problem Compute the minimum number of coins needed to change the given value into coins with de-nominations 1, 5, and 10.
        Input: An integer money.
        Output: The minimum number of coins with denominations 1, 5, and 10 that changes money.
 */
public class MoneyChange {
    
    /**
     * Calculates the minimum number of coins needed to make the specified total amount.
     *
     * @param totalAmount The total amount of money for which to make change. Must be a non-negative integer.
     * @return The minimum number of coins needed to make up the given total amount.
     * @throws IllegalArgumentException if the totalAmount is negative, according to the validation message provided.
     */
    public int calculateMinimumCoinsForChange(int totalAmount) {
        Validate.isTrue(totalAmount >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        int numCoinsFromTens = totalAmount / 10;
        int remainingAfterTens = totalAmount % 10;
        int numCoinsFromFives = remainingAfterTens / 5;
        int numCoinsFromOnes = remainingAfterTens % 5;

        return numCoinsFromTens + numCoinsFromFives + numCoinsFromOnes;
    }
}
