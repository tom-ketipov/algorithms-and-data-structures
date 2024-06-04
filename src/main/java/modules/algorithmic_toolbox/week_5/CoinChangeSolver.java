package modules.algorithmic_toolbox.week_5;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class CoinChangeSolver {

    /**
     * Calculates the minimum number of coins needed to make up the given total money amount
     * using the specified coin denominations.
     * <p>
     * This method uses a dynamic programming approach to solve the problem by building up
     * a solution through memoization of subproblem results.
     * <p>
     * The dynamic programming approach works as follows:
     * - Initialize an array `changeCache` where each index `i` represents the minimum number of coins
     * needed to make up the amount `i`.
     * - For each amount from 1 to `totalMoney`, compute the minimum number of coins required by
     * considering each coin denomination and using previously computed results stored in `changeCache`.
     * - The result for the total amount of money will be stored in `changeCache[totalMoney]`.
     *
     * @param totalMoney        the total amount of money to be changed; must be at least 1.
     * @param coinDenominations an array of valid coin denominations.
     * @return the minimum number of coins needed to make up the given total money amount,
     * or 0 if it is not possible to make up the amount with the given denominations.
     * @throws NullPointerException     if coinDenominations is null.
     * @throws IllegalArgumentException if coinDenominations is empty, or if totalMoney is less than 1.
     * @implNote Time Complexity: O(n * m), where n is the totalMoney and m is the number of coin denominations.
     */
    public int calculateMinCoins(int totalMoney, int[] coinDenominations) {
        Validate.notNull(coinDenominations, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(coinDenominations.length >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        Validate.isTrue(totalMoney >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        int[] changeCache = new int[totalMoney + 1];

        for (int currentMoney = 1; currentMoney < changeCache.length; currentMoney++) {
            int minimumCoins = -1;
            for (int coin : coinDenominations) {
                int coinCount = 0;

                if (currentMoney < coin) break;

                if (coin == currentMoney) {
                    minimumCoins = coinCount + 1;
                    break;
                }

                coinCount = 1 + changeCache[currentMoney - coin];
                if (coinCount < minimumCoins || minimumCoins == -1) {
                    minimumCoins = coinCount;
                }
            }
            if (minimumCoins != -1) changeCache[currentMoney] = minimumCoins;
        }
        return changeCache[changeCache.length - 1];
    }
}