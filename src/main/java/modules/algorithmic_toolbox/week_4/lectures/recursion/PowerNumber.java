package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class PowerNumber {

    /**
     * Calculates the result of raising a given number to a specified non-negative power using recursion.
     *
     * @param number The base number to be raised to the power.
     * @param power  The non-negative power to which the base number is raised.
     * @return The result of raising the base number to the specified power.
     * @throws IllegalArgumentException If the provided power is negative.
     */
    public int recursivePower(int number, int power) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, power, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        if (power == 0) return 1;
        return number * recursivePower(number, power - 1);
    }

    /**
     * Calculates the result of raising a given number to a specified non-negative power.
     *
     * @param number The base number to be raised to the power.
     * @param power  The non-negative power to which the base number is raised.
     * @return The result of raising the base number to the specified power.
     * @throws IllegalArgumentException If the provided power is negative.
     */
    public int linearPower(int number, int power) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, power, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        int result = 1;
        while (power > 0) {
            result *= number;
            power--;
        }
        return result;
    }
}
