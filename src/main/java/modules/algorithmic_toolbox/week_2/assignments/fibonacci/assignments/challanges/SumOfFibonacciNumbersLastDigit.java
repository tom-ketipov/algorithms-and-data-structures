package modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class SumOfFibonacciNumbersLastDigit {

    /**
     * Computes the sum of the last digits of the first 'index' Fibonacci numbers.
     *
     * @param index The upper bound of the sequence range for which to sum the last digits of the Fibonacci numbers.
     *              The index must be a positive integer.
     * @return The sum of the last digits of the Fibonacci numbers up to the specified index.
     * @throws IllegalArgumentException if 'index' is less than or equal to 0.
     */
    public int findSumOfFibonacciNumbersLastDigit(int index) {
        Validate.isTrue(index >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        HugeFibonacciNumber hugeFibonacciNumberSolver = new HugeFibonacciNumber();

        int sum = 0, temp = 1;
        while (temp <= index) {
            sum += hugeFibonacciNumberSolver.getFibonacciNumberMod(temp, 10);
            temp++;
        }
        return sum;
    }
}
