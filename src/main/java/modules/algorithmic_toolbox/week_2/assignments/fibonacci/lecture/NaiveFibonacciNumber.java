package modules.algorithmic_toolbox.week_2.assignments.fibonacci.lecture;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class NaiveFibonacciNumber {

    /**
     * Computes the Fibonacci number at a given index.
     *
     * @param index the position in the sequence (must be non-negative).
     * @return the Fibonacci number at the given index.
     * @throws IllegalArgumentException if index is negative.
     */
    public BigInteger naiveFibonacciFinder(int index) {
        Validate.isTrue(index >= 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0));

        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        int currentIndex = 1;

        while (index > currentIndex) {
            BigInteger temp = b;
            b = a.add(temp);
            a = temp;

            currentIndex++;
        }
        return index >= 1 ? b : a;
    }
}
