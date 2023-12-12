package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import static services.ValidationService.validateInRange;

public class DecimalToBinary {
    /**
     * Converts a decimal number to its binary representation using recursion.
     *
     * @param decimal The decimal number to be converted to binary.
     * @return The binary representation of the given decimal number as a String.
     * @implNote Time complexity: O(log n)
     */
    public String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        } else {
            return convert(decimal, "");
        }
    }

    /**
     * Helper method for converting a decimal number to binary representation recursively.
     *
     * @param num    The decimal number to be converted to binary.
     * @param result The current result of the binary conversion.
     * @return The binary representation of the given decimal number as a String.
     */
    private String convert(int num, String result) {
        if (num == 0) {
            return result;
        } else {
            result = num % 2 + result;
            return convert(num / 2, result);
        }
    }

    /**
     * Converts a decimal number to its binary representation using recursion.
     * The binary representation is returned as a String.
     *
     * @param decimalNumber The decimal number to be converted to binary.
     * @return The binary representation of the given decimal number as a String.
     * @throws IllegalArgumentException If the decimal number is not within the valid range (0 to Integer.MAX_VALUE).
     * @implNote Time complexity: O(log n)
     */
    public String recursiveDecimalToBinary(int decimalNumber) {
        int maxPower = maxPower(decimalNumber);
        return recursiveDecimalToBinary(decimalNumber, maxPower);
    }

    /**
     * Converts a decimal number to its binary representation using recursion.
     *
     * @param decimalNumber The decimal number to be converted to binary.
     * @param maxPower      The maximum power of 2 in the binary representation.
     * @return The binary representation of the given decimal number as a String.
     * @throws IllegalArgumentException If the decimal number is not within the valid range (0 to Integer.MAX_VALUE).
     */
    private String recursiveDecimalToBinary(int decimalNumber, int maxPower) {
        validateInRange(decimalNumber, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

        if (decimalNumber == 0 && maxPower < 0) return "";

        StringBuilder binaryString = new StringBuilder();
        int maxCoefficient = (int) Math.pow(2, maxPower);
        if (decimalNumber >= maxCoefficient) {
            binaryString.append("1");
            decimalNumber -= maxCoefficient;
        } else {
            binaryString.append("0");
        }

        return binaryString.append(recursiveDecimalToBinary(decimalNumber, maxPower - 1)).toString();
    }

    /**
     * Converts a decimal number to its binary representation using a linear approach.
     *
     * @param decimalNumber The decimal number to be converted to binary. Must be non-negative.
     * @return The binary representation of the given decimal number as a string.
     * @throws IllegalArgumentException If the input decimal number is negative.
     * @implNote Time Complexity: O(log₂(decimalNumber))
     */
    public String linearDecimalToBinary(int decimalNumber) {
        validateInRange(decimalNumber, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);

        if (decimalNumber == 0) return "0";

        StringBuilder binaryString = new StringBuilder();
        int maxPower = maxPower(decimalNumber);

        while (maxPower >= 0) {
            int maxCoefficient = (int) Math.pow(2, maxPower);
            if (decimalNumber >= maxCoefficient) {
                binaryString.append("1");
                decimalNumber -= maxCoefficient;
            } else {
                binaryString.append("0");
            }
            maxPower--;
        }
        return binaryString.toString();
    }

    private int maxPower(int decimalNumber) {
        validateInRange(decimalNumber, 0, Integer.MAX_VALUE, ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        return (int) (Math.log(decimalNumber) / Math.log(2));
    }
}
