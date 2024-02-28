package modules.algorithmic_toolbox.bonus.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectTwoRopesTest {
    private ConnectTwoRopes connectTwoRopesSolver;

    @Test
    public void throws_exception_for_null_ropes_array_input() {
        connectTwoRopesSolver = new ConnectTwoRopes();

        try {
            connectTwoRopesSolver.connectRopes(null);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_ropes_array_input() {
        connectTwoRopesSolver = new ConnectTwoRopes();

        try {
            connectTwoRopesSolver.connectRopes(new int[0]);
        } catch (IllegalArgumentException e) {
            assertEquals("The array must not be empty.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_negative_ropes_array_lengths() {
        connectTwoRopesSolver = new ConnectTwoRopes();

        try {
            connectTwoRopesSolver.connectRopes(new int[]{2, -4, 5});
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 1 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void can_calculate_price_for_even_ropes_arr() {
        connectTwoRopesSolver = new ConnectTwoRopes();

        int[] ropes = {1, 5, 23, 4, 332, 12};
        assertEquals(377, connectTwoRopesSolver.connectRopes(ropes));
    }

    @Test
    public void can_calculate_price_for_odd_ropes_arr() {
        connectTwoRopesSolver = new ConnectTwoRopes();

        int[] ropes = {1, 5, 23, 4, 332, 12, 23};
        assertEquals(400, connectTwoRopesSolver.connectRopes(ropes));
    }
}
