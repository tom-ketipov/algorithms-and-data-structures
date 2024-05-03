package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

public class DigitCounter {

    /**
     * Counts the total number of digits in an integer.
     *
     * @param number the integer for which to count the digits
     * @return the total number of digits in the given integer
     */
    public int countTotalDigits(int number) {
        if (Math.abs(number) < 10) return 1;

        return 1 + countTotalDigits(number / 10);
    }
}