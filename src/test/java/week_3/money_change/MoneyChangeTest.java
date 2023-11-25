package week_3.money_change;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class MoneyChangeTest {
    private Change changeSolver;

    @Test
    public void can_get_change_for_single_digit_values() {
        changeSolver = new Change();

        int m = 3;
        Assert.assertEquals(3, changeSolver.getChange(m));
    }

    @Test
    public void can_get_change_for_the_minimum_value() {
        changeSolver = new Change();

        int m = 1;
        Assert.assertEquals(1, changeSolver.getChange(m));
    }

    @Test
    public void can_get_change_for_the_maximum_int_value() {
        changeSolver = new Change();

        int m = Integer.MAX_VALUE;
        Assert.assertEquals(214748367, changeSolver.getChange(m));
    }

    @Test
    public void throws_exception_for_zero_input_parameters() {
        changeSolver = new Change();

        int m = 0;
        try {
            changeSolver.getChange(m);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input cannot be less than 1.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_input_parameters() {
        changeSolver = new Change();

        int m = -19;
        try {
            changeSolver.getChange(m);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input cannot be less than 1.", e.getMessage());
        }
    }
}
