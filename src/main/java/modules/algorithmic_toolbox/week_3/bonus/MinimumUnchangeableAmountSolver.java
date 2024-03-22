package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

/*
        3.3.9 Minimum Unchangeable Amount Problem
        Given a set of coins, determine the minimum amount that cannot be created using any combination of these coins.

        Input:
        An array of coin denominations [c1, c2, ..., cn] where c1 ≤ c2 ≤ ... ≤ cn.
        Output:
        The smallest amount that cannot be obtained using any combination of the given coin denominations.
 */
public class MinimumUnchangeableAmountSolver {

    /**
     * Finds the smallest amount of money that cannot be constructed using any combination of the given coin denominations.
     *
     * @param coinDenominations An array of integers representing the denominations of coins available.
     * @return The smallest integer amount that cannot be obtained by summing the given coin denominations.
     * @throws NullPointerException if the coinDenominations array is null.
     * @implNote Time Complexity: O(n log n).
     */
    public int findSmallestNonConstructableValue(int[] coinDenominations) {
        Validate.notNull(coinDenominations, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        Arrays.sort(coinDenominations);

        if (coinDenominations[0] > 1) return 1;

        int currentConstructibleAmount = 1;
        for (int coin : coinDenominations) {
            if (coin > currentConstructibleAmount) return currentConstructibleAmount;
            currentConstructibleAmount += coin;
        }
        return currentConstructibleAmount;
    }
}
