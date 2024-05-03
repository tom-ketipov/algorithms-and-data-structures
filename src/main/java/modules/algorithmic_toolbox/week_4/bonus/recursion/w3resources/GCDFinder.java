package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

public class GCDFinder {
    /**
     * Finds the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    public int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}