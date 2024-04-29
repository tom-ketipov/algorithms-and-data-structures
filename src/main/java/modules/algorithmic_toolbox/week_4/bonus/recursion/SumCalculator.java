package modules.algorithmic_toolbox.week_4.bonus.recursion;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        Write a program to calculate the sum of numbers from 1 to n using recursion.
 */
public class SumCalculator {

    /**
     * Calculates the sum of numbers from 1 to the specified upper limit.
     *
     * @param upperLimit The upper limit of the range for which the sum is to be calculated.
     * @return The sum of numbers from 1 to the upper limit.
     * @throws IllegalArgumentException if the upperLimit is less than 1
     */
    public int calculateSum(int upperLimit) {
        Validate.isTrue(upperLimit >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        if (upperLimit == 1) return upperLimit;

        return upperLimit + calculateSum(upperLimit - 1);
    }
}
