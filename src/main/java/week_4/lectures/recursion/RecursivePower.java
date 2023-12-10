package week_4.lectures.recursion;

public class RecursivePower {

    /**
     * Calculates the power of a number recursively.
     *
     * @param number The base number.
     * @param power  The exponent to which the base number is raised.
     * @return The result of raising the base number to the specified power.
     * @implNote Time Complexity: O(power)
     */
    public int recursivePower(int number, int power) {
        if (power == 0) return 1;
        return number * recursivePower(number, power - 1);
    }
}
