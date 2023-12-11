package modules.algorithmic_toolbox.week_3.money_change;


import services.ValidationMessages;

import static services.ValidationService.validateInRange;

public class Change {

    /*
        Money Change Problem:
        Compute the minimum number of coins needed to change the given value into coins with
        denominations 1,5 and 10.

        Input: Integer number
        Output: The minimum number of coins with denominations 1,5 and 10 that changes money
        ======================================================================================
        Time Complexity: O(1)
     */
    public int getChange(int m) {
        validateInRange(m, 1, Integer.MAX_VALUE, ValidationMessages.NON_POSITIVE_NUMBER_EXCEPTION_MESSAGE);

        // Calculate the number of 10-coins and update m
        int count = m / 10;
        m %= 10;

        // Calculate the number of 5-coins and update m
        count += m / 5;
        m %= 5;

        // The remaining m is the number of 1-coins
        count += m;
        return count;
    }
}
