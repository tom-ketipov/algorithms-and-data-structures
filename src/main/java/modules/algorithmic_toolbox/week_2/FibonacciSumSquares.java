package modules.algorithmic_toolbox.week_2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSumSquares {
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

    private static long getFibonacciSumSquared(long n) {
        BigInteger sum = BigInteger.valueOf(1);
        while (n > 1) {
            BigInteger fibNumber = nthFibonacciTerm(n--);
            sum = sum.add(fibNumber.pow(2));
        }
        return sum.mod(BigInteger.valueOf(10)).intValue();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquared(n);
        System.out.println(s);
    }
}
