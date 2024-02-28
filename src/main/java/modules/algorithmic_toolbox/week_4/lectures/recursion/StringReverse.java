package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.apache.commons.lang3.Validate;
import utils.ValidationMessageUtility;

public class StringReverse {

    /**
     * Reverses a given string using a recursive approach.
     *
     * @param str The input string to be reversed. Must not be null.
     * @return The reversed string.
     * @throws NullPointerException if the input string is null.
     * @implNote Time Complexity: O(n)
     */
    public String recursiveReverse(String str) {
        Validate.notNull(str, ValidationMessageUtility.getMessage("not_null_array_exception"));

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
     * @throws NullPointerException if the input string is null.
     * @implNote Time complexity: O(n).
     */
    public String linearReverse(String str) {
        Validate.notNull(str, ValidationMessageUtility.getMessage("not_null_array_exception"));

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
