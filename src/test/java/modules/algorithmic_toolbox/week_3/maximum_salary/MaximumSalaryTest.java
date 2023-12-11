package modules.algorithmic_toolbox.week_3.maximum_salary;

import org.junit.jupiter.api.Test;

import static modules.algorithmic_toolbox.week_3.maximum_salary.LargestNumber.NON_NULL_NUMBERS_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSalaryTest {
    private LargestNumber largestNumberSolver;

    @Test
    public void can_generate_largest_number_for_arr_with_one_digit_max_length_difference() {
        largestNumberSolver = new LargestNumber();

        String[] a = {"9", "21", "19", "3", "7"};
        assertEquals("9732119", largestNumberSolver.largestNumber(a));
    }

    @Test
    public void can_generate_largest_number_for_arr_with_five_digit_max_length_difference() {
        largestNumberSolver = new LargestNumber();

        String[] a = {"3", "30", "34", "5", "9"};
        assertEquals("9534330", largestNumberSolver.largestNumber(a));
    }

    @Test
    public void can_handle_empty_arrays() {
        largestNumberSolver = new LargestNumber();

        String[] a = {};
        assertEquals("", largestNumberSolver.largestNumber(a));
    }

    @Test
    public void throws_exception_for_null_input_parameters() {
        largestNumberSolver = new LargestNumber();

        try {
            largestNumberSolver.largestNumber(null);
        } catch (IllegalArgumentException e) {
            assertEquals(NON_NULL_NUMBERS_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
