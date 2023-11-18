package week_2;

import java.util.Scanner;

public class LCM {
    public static long euclideanGCD(long a, long b) {
        while (true) {
            long max = Math.max(a, b);
            long min = Math.min(a, b);
            long remainder = max % min;

            if (remainder == 0) {
                return min;
            }

            a = min;
            b = remainder;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.println((a * b) / euclideanGCD(a, b));
    }
}
