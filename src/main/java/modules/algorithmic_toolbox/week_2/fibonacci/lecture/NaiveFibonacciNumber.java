package modules.algorithmic_toolbox.week_2.fibonacci.lecture;

import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class NaiveFibonacciNumber {

    public BigInteger naiveFibonacciFinder(int index) {
        Validate.isTrue(index >= 0);

        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger temp;
        int currentIndex = 1;

        while (index > currentIndex) {
            temp = b;
            b = a.add(temp);
            a = temp;

            currentIndex++;
        }

        return index >= 1 ? b : a;
    }
}
