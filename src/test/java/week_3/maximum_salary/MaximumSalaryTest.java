package week_3.maximum_salary;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.security.InvalidParameterException;

public class MaximumSalaryTest extends BaseTest {
    private LargestNumber largestNumberSolver;

    @Test
    public void can_generate_largest_number_for_arr_with_one_digit_max_length_difference() {
        largestNumberSolver = new LargestNumber();

        String[] a = {"9", "21", "19", "3", "7"};
        Assert.assertEquals("9732119", largestNumberSolver.largestNumber(a));
    }

    @Test
    public void can_generate_largest_number_for_arr_with_five_digit_max_length_difference() {
        largestNumberSolver = new LargestNumber();

        String[] a = {"3", "30", "34", "5", "9"};
        Assert.assertEquals("9534330", largestNumberSolver.largestNumber(a));
    }

    @Test
    public void can_handle_empty_arrays() {
        largestNumberSolver = new LargestNumber();

        String[] a = {};
        Assert.assertEquals("", largestNumberSolver.largestNumber(a));
    }

    @Ignore
    @Test
    public void throws_exception_for_null_input_parameters() {
        largestNumberSolver = new LargestNumber();

        try {
            largestNumberSolver.largestNumber(null);
        } catch (InvalidParameterException e) {
            Assert.assertEquals(e.getMessage(), "Array cannot be null.");
        }
    }

}
