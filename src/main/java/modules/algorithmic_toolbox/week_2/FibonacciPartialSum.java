package modules.algorithmic_toolbox.week_2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciPartialSum {
    public static BigInteger nthFibonacciTerm(long n) {
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger n0 = BigInteger.valueOf(0), n1 = BigInteger.valueOf(1);
        BigInteger tempNthTerm;
        for (int i = 2; i <= n; i++) {
            tempNthTerm = n0.add(n1);
            n0 = n1;
            n1 = tempNthTerm;
        }
        return n1;
    }

    private static int getFibonacciPartialSum(long from, long to) {
        BigInteger sum = BigInteger.valueOf(0);
        int index = 1;
        while (index <= to) {
            BigInteger fibNumber = nthFibonacciTerm(index++);
            if (index > from) {
                sum = sum.add(fibNumber);
            }
        }
        return sum.mod(BigInteger.valueOf(10)).intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
