package modules.algorithmic_toolbox.week_4.lectures.recursion;

import static services.ValidationService.validateNotNull;

public class StringReverse {
    public static final String NOT_NULL_STRING_EXCEPTION_MESSAGE = "The input String cannot be null.";

    /**
     * Reverses a given string using a recursive approach.
     *
     * @param str The input string to be reversed. Must not be null.
     * @return The reversed string.
     * @throws IllegalArgumentException if the input string is null.
     * @implNote Time Complexity: O(n)
     */
    public String recursiveReverse(String str) {
        validateNotNull(str, NOT_NULL_STRING_EXCEPTION_MESSAGE);

        // Base case
        if (str.length() <= 1) {
            return str;
        }
        return recursiveReverse(str.substring(1)) + str.charAt(0);
    }

    /**
     * Reverses a given string using a linear approach.
     *
     * @param str The input string to be reversed. Must not be null.
     * @return The reversed string.
     * @throws IllegalArgumentException if the input string is null.
     * @implNote Time complexity: O(n).
     */
    public String linearReverse(String str) {
        validateNotNull(str, NOT_NULL_STRING_EXCEPTION_MESSAGE);

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
