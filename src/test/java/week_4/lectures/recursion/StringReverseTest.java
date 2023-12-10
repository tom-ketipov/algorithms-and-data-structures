package week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static week_4.lectures.recursion.StringReverse.NULL_STRING_EXCEPTION_MESSAGE;

class StringReverseTest {
    private StringReverse stringReverseSolver;

    @BeforeEach
    public void setUp() {
        stringReverseSolver = new StringReverse();
    }

    @Test
    public void can_reverse_string_with_linear_function() {
        String str = "Help Me!";
        assertEquals("!eM pleH", stringReverseSolver.linearReverse(str));
    }

    @Test
    public void can_reverse_single_length_string_with_linear_function() {
        String str = "H";
        assertEquals("H", stringReverseSolver.linearReverse(str));
    }

    @Test
    public void linear_function_throws_exception_for_null_input() {
        try {
            stringReverseSolver.linearReverse(null);
        } catch (IllegalArgumentException e) {
            assertEquals(NULL_STRING_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_reverse_string_with_recursive_function() {
        String str = "Help Me!";
        assertEquals("!eM pleH", stringReverseSolver.recursiveReverse(str));
    }

    @Test
    public void can_reverse_single_length_string_with_recursive_function() {
        String str = "H";
        assertEquals("H", stringReverseSolver.recursiveReverse(str));
    }

}