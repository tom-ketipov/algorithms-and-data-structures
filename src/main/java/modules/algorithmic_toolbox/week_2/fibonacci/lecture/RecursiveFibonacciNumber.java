package modules.algorithmic_toolbox.week_2.fibonacci.lecture;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class RecursiveFibonacciNumber {

    /**
     * Computes the Fibonacci number at a given index using recursion.
     *
     * @param index the position in the sequence for which to compute the Fibonacci number, must be non-negative.
     * @return the Fibonacci number at the specified index.
     * @throws IllegalArgumentException if index is negative.
     * @implNote Very, very slow algorithm. (Non-usable for even 100th index)
     */
    public BigInteger recursiveFibonacciFinder(int index) {
        Validate.isTrue(index >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        if (index <= 1) return BigInteger.valueOf(index);

        return recursiveFibonacciFinder(index - 1).add(recursiveFibonacciFinder(index - 2));
    }
}
