package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.apache.commons.lang3.Validate;

public class PartialSumOfFibonacciNumbersLastDigit {

    /**
     * Calculates the last digit of the partial sum of the first 'index' Fibonacci numbers.
     *
     * @param index The upper bound of the Fibonacci sequence to sum, must be a positive integer.
     * @return The last digit of the sum of the first 'index' Fibonacci numbers.
     * @throws IllegalArgumentException if 'index' is less than or equal to 0.
     */
    public int findPartialSumOfFibonacciNumbersLastDigits(int index) {
        Validate.isTrue(index > 0);

        HugeFibonacciNumber hugeFibonacciNumberSolver = new HugeFibonacciNumber();

        int sum = 0, temp = 1;
        while (temp <= index) {
            sum += hugeFibonacciNumberSolver.getFibonacciNumberMod(temp, 10);
            temp++;
        }
        return sum % 10;
    }
}
