package modules.algorithmic_toolbox.week_4.lectures.recursion;

public class GCD {
    /**
     * Calculates the Greatest Common Divisor (GCD) of two non-negative integers using the Euclidean Algorithm.
     * The GCD is the largest positive integer that divides both input integers without a remainder.
     *
     * @param a The first non-negative integer.
     * @param b The second non-negative integer.
     * @return The Greatest Common Divisor (GCD) of the two input integers.
     * @throws IllegalArgumentException If either of the input integers is negative.
     * @implNote Time Complexity:  O(log min(a, b))
     */
    public int recursiveGCDWithEuclidAlgorithm(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int gcd = a % b;

        if (a % gcd == 0 && b % gcd == 0) return gcd;
        return recursiveGCDWithEuclidAlgorithm(b, gcd);
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two non-negative integers using the Euclidean Algorithm.
     * The GCD is the largest positive integer that divides both input integers without a remainder.
     *
     * @param a The first non-negative integer.
     * @param b The second non-negative integer.
     * @return The Greatest Common Divisor (GCD) of the two input integers.
     * @throws IllegalArgumentException If either of the input integers is negative.
     * @implNote Time Complexity: O(log min(a, b))
     */
    public int linearGCDWithEuclidAlgorithm(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        do {
            int gcd = Math.max(a, b) % Math.min(a, b);
            if (a % gcd == 0 && b % gcd == 0) return gcd;

            a = b;
            b = gcd;
        } while (true);
    }
}
