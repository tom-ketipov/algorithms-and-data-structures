package modules.algorithmic_toolbox.week_3.money_change;


import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

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
        int minValue = 1;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, m, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

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
