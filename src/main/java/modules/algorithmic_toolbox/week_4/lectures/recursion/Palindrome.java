package modules.algorithmic_toolbox.week_4.lectures.recursion;

import services.ValidationMessages;

import static services.ValidationService.validateNotNull;

public class Palindrome {

    /**
     * Checks if a given string is a palindrome using a recursive approach.
     * <p>
     * This method uses recursion to determine whether the provided string is a palindrome.
     *
     * @param word The string to check for palindromicity.
     * @return {@code true} if the string is a palindrome, {@code false} otherwise.
     * @throws IllegalArgumentException if the input string is null.
     */
    public boolean recursivePalindrome(String word) {
        return recursivePalindrome(word, 0, word.length() - 1);
    }

    /**
     * Checks if a given string is a palindrome recursively.
     *
     * @param word  The string to check for palindromicity.
     * @param start The starting index for the comparison.
     * @param end   The ending index for the comparison.
     * @return {@code true} if the substring is a palindrome, {@code false} otherwise.
     * @throws IllegalArgumentException if the input string is null.
     */
    public boolean recursivePalindrome(String word, int start, int end) {
        validateNotNull(word, ValidationMessages.NOT_NULL_STRING_EXCEPTION_MESSAGE);

        if (start >= end) return true;

        if (word.charAt(start) == word.charAt(end)) {
            return recursivePalindrome(word, start + 1, end - 1);
        } else {
            return false;
        }
    }

    /**
     * Checks if a given string is a palindrome using a linear approach.
     *
     * @param word The string to be checked for palindrome property.
     * @return {@code true} if the string is a palindrome, {@code false} otherwise.
     * @throws IllegalArgumentException if the input string is null or empty.
     *                                  Time Complexity: O(n)
     */
    public boolean linearPalindrome(String word) {
        validateNotNull(word, ValidationMessages.NOT_NULL_STRING_EXCEPTION_MESSAGE);

        for (int i = 0, j = word.length() - 1; i <= j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }
}
