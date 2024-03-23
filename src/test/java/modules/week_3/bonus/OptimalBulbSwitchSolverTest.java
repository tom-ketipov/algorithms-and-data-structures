package modules.week_3.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.OptimalBulbSwitchSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptimalBulbSwitchSolverTest {

    private OptimalBulbSwitchSolver optimalBulbSwitchSolver;

    @BeforeEach
    public void setUp() {
        optimalBulbSwitchSolver = new OptimalBulbSwitchSolver();
    }

    @Test
    public void should_return_zero_for_input_where_all_lights_are_already_on() {
        int[] initialBulbStates = {1, 1, 1, 1, 1, 1};

        Assertions.assertEquals(0, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void should_return_one_for_input_where_there_is_only_one_light_that_is_off() {
        int[] initialBulbStates = {0};

        Assertions.assertEquals(1, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void should_return_one_for_input_where_all_initial_states_are_off() {
        int[] initialBulbStates = {0, 0, 0, 0, 0, 0, 0};

        Assertions.assertEquals(1, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void should_return_one_for_input_where_the_first_state_is_on_and_all_other_states_are_off() {
        int[] initialBulbStates = {1, 0, 0, 0, 0, 0, 0};

        Assertions.assertEquals(1, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void should_return_two_for_input_where_there_are_multiple_lights_and_only_the_last_is_on() {
        int[] initialBulbStates = {0, 0, 0, 0, 0, 1};

        Assertions.assertEquals(2, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void should_return_return_correct_value_for_input_with_alternating_states() {
        int[] initialBulbStates = {0, 1, 0, 1};

        Assertions.assertEquals(4, optimalBulbSwitchSolver.calculateMinimumSwitchPresses(initialBulbStates));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input() {
        try {
            optimalBulbSwitchSolver.calculateMinimumSwitchPresses(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
