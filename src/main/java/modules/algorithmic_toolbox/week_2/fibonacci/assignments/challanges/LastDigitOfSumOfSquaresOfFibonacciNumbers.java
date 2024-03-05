package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class LastDigitOfSumOfSquaresOfFibonacciNumbers {

    /**
     * Computes the last digit of the sum of the squares of the first 'index' Fibonacci numbers.
     *
     * @param index The sequence limit to which the Fibonacci numbers are squared and summed. Must be a positive integer.
     * @return The last digit of the sum of the squares of the Fibonacci numbers up to the given index.
     * @throws IllegalArgumentException if 'index' is less than or equal to 0.
     */
    public int findPartialSumOfFibonacciNumbersLastDigits(int index) {
        Validate.isTrue(index > 0);

        HugeFibonacciNumber hugeFibonacciNumberSolver = new HugeFibonacciNumber();

        int sum = 0, temp = 1;
        while (temp <= index) {
            BigInteger squaredFibNumber = hugeFibonacciNumberSolver.findFibonacciNumber(temp).pow(2);
            sum += squaredFibNumber.mod(BigInteger.TEN).intValue();
            temp++;
        }
        return sum % 10;
    }
}
