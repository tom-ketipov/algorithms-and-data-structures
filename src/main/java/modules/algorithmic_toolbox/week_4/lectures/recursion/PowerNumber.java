package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import static services.ValidationService.validateInRange;

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
        validateInRange(power, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateInRange(power, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

        int result = 1;
        while (power > 0) {
            result *= number;
            power--;
        }
        return result;
    }
}
