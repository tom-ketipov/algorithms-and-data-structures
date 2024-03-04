package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class LastDigitOfFibonacciNumber {

    /**
     * Retrieves the last digit of the Fibonacci number at the specified index.
     *
     * @param index the index in the Fibonacci sequence, must be non-negative.
     * @return the last digit of the Fibonacci number at the given index.
     * @throws IllegalArgumentException if index is negative.
     */
    public int getLastFibonacciNumberDigit(int index) {
        Validate.isTrue(index >= 0);

        return findFibonacci(index).mod(BigInteger.valueOf(10)).intValue();
    }

    /**
     * Calculates the Fibonacci number at a specified index efficiently.
     * This method uses an iterative approach with a cache to avoid recalculations.
     *
     * @param index the position in the Fibonacci sequence to find. Must be non-negative.
     * @return the Fibonacci number at the given index.
     */
    private BigInteger findFibonacci(int index) {
        if (index <= 1) return BigInteger.valueOf(index);

        BigInteger[] fibonacciNumberCache = {BigInteger.ZERO, BigInteger.ONE};

        for (int i = 2; i <= index; i++) {
            BigInteger next = fibonacciNumberCache[0].add(fibonacciNumberCache[1]);
            fibonacciNumberCache[0] = fibonacciNumberCache[1];
            fibonacciNumberCache[1] = next;
        }

        return fibonacciNumberCache[1];
    }
}
