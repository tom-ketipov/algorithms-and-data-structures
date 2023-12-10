package week_4.lectures.recursion;

public class StringReverse {
    public static final String NULL_STRING_EXCEPTION_MESSAGE = "String cannot be null.";

    /**
     * Reverses a given string using a recursive approach.
     *
     * @param str The input string to be reversed. Must not be null.
     * @return The reversed string.
     * @throws IllegalArgumentException if the input string is null.
     * @implNote Time Complexity: O(n)
     */
    public String recursiveReverse(String str) {
        validateNotNullString(str);

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
        validateNotNullString(str);

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    /**
     * Validates that the input string is not null.
     *
     * @param str The string to be validated.
     * @throws IllegalArgumentException if the input string is null.
     */
    private void validateNotNullString(String str) {
        if (str == null) {
            throw new IllegalArgumentException(NULL_STRING_EXCEPTION_MESSAGE);
        }
    }
}
