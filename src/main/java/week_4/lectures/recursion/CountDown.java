package week_4.lectures.recursion;

public class CountDown {
    private static final String NEGATIVE_TIME_EXCEPTION_MESSAGE = "Time must be a non-negative value.";

    /**
     * Recursively counts down from the specified maximum time, printing each countdown value.
     *
     * @param maxTime The maximum time to start the countdown from. Must be non-negative.
     * @throws IllegalArgumentException if time is negative
     * @implNote Time Complexity: O(n)
     */
    private static void recursiveCountDown(int maxTime) {
        validateNonNegativeTime(maxTime);

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
        validateNonNegativeTime(maxTime);

        while (maxTime > 0) {
            System.out.println(maxTime--);
        }
    }

    private static void validateNonNegativeTime(int maxTime) {
        if (maxTime < 0) {
            throw new IllegalArgumentException(NEGATIVE_TIME_EXCEPTION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int maxTime = 10;

        linearCountDown(maxTime);
        recursiveCountDown(maxTime);
    }
}
