package modules.algorithmic_toolbox.week_2.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.bonus.JosephusProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class JosephusProblemTest {

    private JosephusProblem josephusProblemSolver;

    @BeforeEach
    void setUp() {
        josephusProblemSolver = new JosephusProblem();
    }

    @Test
    public void can_find_last_rebel_standing_when_elimination_step_is_smaller_than_total_number_of_rebels() {
        Assertions.assertEquals(26, josephusProblemSolver.josephus(100, 10));
    }

    @Test
    public void can_find_last_rebel_standing_when_elimination_step_is_equal_to_the_total_number_of_rebels() {
        Assertions.assertEquals(5, josephusProblemSolver.josephus(7, 7));
    }

    @Test
    public void can_find_last_rebel_standing_when_there_is_only_one_rebel() {
        Assertions.assertEquals(1, josephusProblemSolver.josephus(1, 1));
    }

    @Test
    public void can_find_last_rebel_standing_when_the_elimination_step_is_bigger_than_the_number_of_rebels_for_more_than_one_total_rebels() {
        Assertions.assertEquals(2, josephusProblemSolver.josephus(2, 3));
    }

    @Test
    public void can_find_last_rebel_standing_for_larger_values() {
        Assertions.assertEquals(126723229, josephusProblemSolver.josephus(155060124, 88493));
    }

    @Test
    public void can_handle_zero_value_input_for_total_rebels_parameter() {
        try {
            josephusProblemSolver.josephus(0, 32);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_value_input_for_total_rebels_parameter() {
        try {
            josephusProblemSolver.josephus(-1, 32);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_value_input_for_elimination_step_parameter() {
        try {
            josephusProblemSolver.josephus(2310, 0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_value_input_for_elimination_step_parameter() {
        try {
            josephusProblemSolver.josephus(442, -1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}