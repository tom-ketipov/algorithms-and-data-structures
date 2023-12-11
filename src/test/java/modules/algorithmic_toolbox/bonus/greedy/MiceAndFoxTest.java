package modules.algorithmic_toolbox.bonus.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiceAndFoxTest {
    private MiceAndFox miceAndFoxSolver;

    @Test
    public void can_find_max_hiding_time_with_positive_position_values() {
        miceAndFoxSolver = new MiceAndFox();

        int[] micePositions = {0, 2, 4};
        int[] holesPositions = {0, 4, 5};
        assertEquals(2, miceAndFoxSolver.hide(micePositions, holesPositions));
    }

    @Test
    public void can_find_max_hiding_time_with_negative_position_values() {
        miceAndFoxSolver = new MiceAndFox();

        int[] micePositions = {-94, -85, -79, -79, -28, -10, 67, 93};
        int[] holesPositions = {-31, -2, 9, 23, 25, 50, 69, 78};
        assertEquals(102, miceAndFoxSolver.hide(micePositions, holesPositions));
    }
}
