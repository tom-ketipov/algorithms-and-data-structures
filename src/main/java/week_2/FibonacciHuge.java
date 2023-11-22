package week_2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciHuge {
    private static BigInteger fib(long n) {
        BigInteger[][] F = new BigInteger[][]{{BigInteger.valueOf(1), BigInteger.valueOf(1)}, {BigInteger.valueOf(1), BigInteger.valueOf(0)}};
        if (n == 0)
            return BigInteger.valueOf(0);
        power(F, n - 1);

        return F[0][0];
    }

    private static void power(BigInteger[][] F, long n) {
        if (n == 0 || n == 1)
            return;
        BigInteger[][] M = new BigInteger[][]{{BigInteger.valueOf(1), BigInteger.valueOf(1)}, {BigInteger.valueOf(1), BigInteger.valueOf(0)}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    private static void multiply(BigInteger[][] F, BigInteger[][] M) {
        BigInteger x = (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
        BigInteger y = (F[0][0].multiply(M[0][1])).add(F[0][1].multiply(M[1][1]));
        BigInteger z = (F[1][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
        BigInteger w = (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    private static int getFibonacciHuge(long n, long m) {
        return (fib(n).mod(BigInteger.valueOf(m))).intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
