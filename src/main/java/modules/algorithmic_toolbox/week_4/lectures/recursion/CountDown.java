package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import static services.ValidationService.validateInRange;

public class CountDown {

    /**
     * Recursively counts down from the specified maximum time, printing each countdown value.
     *
     * @param maxTime The maximum time to start the countdown from. Must be non-negative.
     * @throws IllegalArgumentException if time is negative
     * @implNote Time Complexity: O(n)
     */
    private static void recursiveCountDown(int maxTime) {
        validateInRange(maxTime, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
        validateInRange(maxTime, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

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
