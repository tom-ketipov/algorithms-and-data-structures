package modules.algorithmic_toolbox.week_2.fibonacci.lecture;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class RecursiveFibonacciNumber {

    // Very, very slow algorithm. (Non-usable for even 100th index)
    public BigInteger recursiveFibonacciFinder(int index) {
        Validate.isTrue(index >= 0);

        if (index <= 1) return BigInteger.valueOf(index);

        return recursiveFibonacciFinder(index - 1).add(recursiveFibonacciFinder(index - 2));
    }
}
