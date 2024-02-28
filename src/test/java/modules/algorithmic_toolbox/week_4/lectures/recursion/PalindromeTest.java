package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    private Palindrome palindromeSolver;

    @BeforeEach
    public void setUp() {
        palindromeSolver = new Palindrome();
    }

    @Test
    public void can_detect_palindrome_in_valid_string_with_linear_function() {
        String word = "kayak";
        assertTrue(palindromeSolver.linearPalindrome(word));
    }

    @Test
    public void can_detect_palindrome_in_valid_even_length_string_with_linear_function() {
        String word = "kayyak";
        assertTrue(palindromeSolver.linearPalindrome(word));
    }

    @Test
    public void can_detect_palindrome_in_single_length_string_with_linear_function() {
        String word = "g";
        assertTrue(palindromeSolver.linearPalindrome(word));
    }

    @Test
    public void cant_detect_palindrome_in_invalid_string_with_linear_function() {
        String word = "karyak";
        assertFalse(palindromeSolver.linearPalindrome(word));
    }

    @Test
    public void cant_detect_palindrome_in_invalid_string_with_recursive_function() {
        String word = "kayaka";
        assertFalse(palindromeSolver.recursivePalindrome(word));
    }

    @Test
    public void can_detect_palindrome_in_valid_string_with_recursive_function() {
        String word = "kayak";
        assertTrue(palindromeSolver.recursivePalindrome(word));
    }

    @Test
    public void can_detect_palindrome_in_valid_even_length_string_with_recursive_function() {
        String word = "kayyak";
        assertTrue(palindromeSolver.recursivePalindrome(word));
    }

    @Test
    public void can_detect_palindrome_in_single_length_string_with_recursive_function() {
        String word = "g";
        assertTrue(palindromeSolver.recursivePalindrome(word));
    }

    @Test
    public void throws_exception_for_null_input_strings() {
        try {
            palindromeSolver.linearPalindrome(null);
        } catch (NullPointerException e) {
            assertEquals("The input string must not be null.", e.getMessage());
        }
    }
}