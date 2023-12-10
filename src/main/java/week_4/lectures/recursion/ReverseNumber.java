package week_4.lectures.recursion;

public class ReverseNumber {
    /**
     * Reverses the digits of an integer using a recursive approach.
     *
     * @param originalNumber The non-negative integer to be reversed.
     * @return The reversed integer.
     * @implNote Time Complexity: O(log10(originalNumber))
     **/
    public int recursiveReverse(int originalNumber) {
        originalNumber = Math.abs(originalNumber);

        // Base Case
        if (originalNumber == 0) return 0;

        int power = (int) Math.pow(10, Math.floor(Math.log10(originalNumber)));
        int lastDigit = originalNumber % 10;

        int reversedRemaining = recursiveReverse(originalNumber / 10);
        return (lastDigit * power) + reversedRemaining;
    }

    /**
     * Reverses the digits of a non-negative integer using a linear approach.
     *
     * @param originalNumber The non-negative integer to be reversed.
     * @return The reversed integer.
     * @throws IllegalArgumentException if the input integer is negative.
     * @implNote Time complexity: O(log10(originalNumber))
     */
    public int linearReverse(int originalNumber) {
        originalNumber = Math.abs(originalNumber);

        int reversedNumber = 0;
        while (originalNumber > 0) {
            int power = (int) Math.pow(10, Math.floor(Math.log10(originalNumber)));
            int lastDigit = originalNumber % 10;

            reversedNumber += lastDigit * power;
            originalNumber /= 10;
        }
        return reversedNumber;
    }
}