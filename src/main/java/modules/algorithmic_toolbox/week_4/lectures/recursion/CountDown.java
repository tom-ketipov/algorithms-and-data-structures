package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class CountDown {

    /**
     * Recursively counts down from the specified maximum time, printing each countdown value.
     *
     * @param maxTime The maximum time to start the countdown from. Must be non-negative.
     * @throws IllegalArgumentException if time is negative
     * @implNote Time Complexity: O(n)
     */
    private static void recursiveCountDown(int maxTime) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, maxTime, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        if (maxTime == 0) return;

        System.out.println(maxTime);
        recursiveCountDown(maxTime - 1);
    }


    /**
     * Linearly counts down from the specified maximum time, printing each countdown value.
     *
     * @param maxTime The maximum time to start the countdown from. Must be non-negative.
     * @throws IllegalArgumentException if time is negative
     * @implNote Time Complexity: O(n)
     **/
    private static void linearCountDown(int maxTime) {
        int minValue = 0;
        int maxValue = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minValue, maxValue, maxValue, ValidationMessageUtility.getMessage("value_range_exception", minValue, maxValue));

        while (maxTime > 0) {
            System.out.println(maxTime--);
        }
    }


    public static void main(String[] args) {
        int maxTime = 10;

        linearCountDown(maxTime);
        recursiveCountDown(maxTime);
    }
}
