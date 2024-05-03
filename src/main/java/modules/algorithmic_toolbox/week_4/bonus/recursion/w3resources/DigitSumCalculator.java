package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

public class DigitSumCalculator {

    /**
     * Calculates the sum of the digits of a given number.
     *
     * @param number the number whose digit sum is to be calculated
     * @return the sum of the digits of the given number
     */
    public int findDigitSum(int number) {
        if (Math.abs(number) < 10) return Math.abs(number);

        return findDigitSum((number / 10) % 10) + findDigitSum(number % 10);
    }
}