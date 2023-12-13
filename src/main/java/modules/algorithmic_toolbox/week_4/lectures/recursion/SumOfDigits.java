package modules.algorithmic_toolbox.week_4.lectures.recursion;

public class SumOfDigits {
    /**
     * This method calculates the sum of the digits of a given number using recursion.
     *
     * @param number the integer for which the sum of digits is to be calculated
     * @return the sum of digits of the given number
     * @implNote Time Complexity: O(n)
     */
    public int recursiveSum(int number) {
        if (number < 0) number = -number;

        if (number < 10) return number;
        return number % 10 + recursiveSum((number / 10));
    }

    /**
     * This method calculates the sum of the digits of a given number using a linear loop.
     *
     * @param number the integer for which the sum of digits is to be calculated
     * @return the sum of digits of the given number
     * @implNote Time Complexity: O(n)
     */
    public int linearSum(int number) {
        if (number < 0) number = -number;

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
