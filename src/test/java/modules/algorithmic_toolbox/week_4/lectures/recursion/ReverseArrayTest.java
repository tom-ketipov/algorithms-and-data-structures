package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.*;

class ReverseArrayTest {
    private ReverseArray reverseArraySolver;

    @BeforeEach
    public void setUp() {
        reverseArraySolver = new ReverseArray();
    }

    @Test
    public void can_reverse_even_sized_array_with_linear_function() {
        int[] arr = {1, 5, 6, 8};
        assertArrayEquals(new int[]{8, 6, 5, 1}, reverseArraySolver.linerArrayReverse(arr));
    }

    @Test
    public void can_reverse_odd_sized_array_with_linear_function() {
        int[] arr = {1, 5, 6, 8, 9};
        assertArrayEquals(new int[]{9, 8, 6, 5, 1}, reverseArraySolver.linerArrayReverse(arr));
    }

    @Test
    public void linear_function_throws_exception_for_null_input() {
        try {
            reverseArraySolver.linerArrayReverse(null);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NON_NULL_ARRAY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_reverse_even_sized_array_with_recursive_function() {
        int[] arr = {1, 5, 6, 8};
        assertArrayEquals(new int[]{8, 6, 5, 1}, reverseArraySolver.recursiveArrayReverse(arr));
    }

    @Test
    public void can_reverse_odd_sized_array_with_recursive_function() {
        int[] arr = {1, 5, 6, 8, 9};
        assertArrayEquals(new int[]{9, 8, 6, 5, 1}, reverseArraySolver.recursiveArrayReverse(arr));
    }
}