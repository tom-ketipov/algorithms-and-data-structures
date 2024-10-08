package modules.algorithmic_toolbox.week_2.assignments.fibonacci;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

/*
        Last Digit of the Partial Sum of Fibonacci Numbers Problem
        Compute the last digit of Fm + Fm+1 + · · · + Fn .
 */
public class PartialSumOfFibonacciNumbersLastDigit {

    /**
     * Calculates the last digit of the partial sum of the first 'index' Fibonacci numbers.
     *
     * @param index The upper bound of the Fibonacci sequence to sum, must be a positive integer.
     * @return The last digit of the sum of the first 'index' Fibonacci numbers.
     * @throws IllegalArgumentException if 'index' is less than or equal to 0.
     */
    public int findPartialSumOfFibonacciNumbersLastDigits(int index) {
        Validate.isTrue(index >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        HugeFibonacciNumber hugeFibonacciNumberSolver = new HugeFibonacciNumber();

        int sum = 0, temp = 1;
        while (temp <= index) {
            sum += hugeFibonacciNumberSolver.getFibonacciNumberMod(temp, 10);
            temp++;
        }
        return sum % 10;
    }
}
