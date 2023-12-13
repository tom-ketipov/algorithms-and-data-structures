package modules.algorithmic_toolbox.week_3.money_change;

import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyChangeTest {
    private Change changeSolver;

    @Test
    public void can_get_change_for_single_digit_values() {
        changeSolver = new Change();

        int m = 3;
        assertEquals(3, changeSolver.getChange(m));
    }

    @Test
    public void can_get_change_for_the_minimum_value() {
        changeSolver = new Change();

        int m = 1;
        assertEquals(1, changeSolver.getChange(m));
    }

    @Test
    public void can_get_change_for_the_maximum_int_value() {
        changeSolver = new Change();

        int m = Integer.MAX_VALUE;
        assertEquals(214748367, changeSolver.getChange(m));
    }

    @Test
    public void throws_exception_for_zero_input_parameters() {
        changeSolver = new Change();

        int m = 0;
        try {
            changeSolver.getChange(m);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_input_parameters() {
        changeSolver = new Change();

        int m = -19;
        try {
            changeSolver.getChange(m);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
