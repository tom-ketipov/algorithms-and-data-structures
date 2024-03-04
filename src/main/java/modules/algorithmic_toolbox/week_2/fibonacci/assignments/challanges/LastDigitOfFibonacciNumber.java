package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class LastDigitOfFibonacciNumber {

    public int getLastFibonacciNumberDigit(int index) {
        Validate.isTrue(index >= 0);

        return findFibonacci(index).mod(BigInteger.valueOf(10)).intValue();
    }

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
