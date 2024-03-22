package modules.week_3.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.MiceAndFox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiceAndFoxTest {
    private MiceAndFox miceAndFoxSolver;

    @BeforeEach
    public void setUp() {
        miceAndFoxSolver = new MiceAndFox();
    }

    @Test
    public void can_construct_a_mouse_with_positive_position() {
        MiceAndFox.Mouse mouse = new MiceAndFox.Mouse(1, 5);
        Assertions.assertEquals(5, mouse.getPosition());
    }

    @Test
    public void can_construct_a_mouse_with_zero_position() {
        MiceAndFox.Mouse mouse = new MiceAndFox.Mouse(1, 0);
        Assertions.assertEquals(0, mouse.getPosition());
    }

    @Test
    public void can_construct_a_mouse_with_negative_position() {
        MiceAndFox.Mouse mouse = new MiceAndFox.Mouse(1, -842);
        Assertions.assertEquals(-842, mouse.getPosition());
    }

    @Test
    public void can_hide_mice_optimally() {
        MiceAndFox.Mouse[] mice = new MiceAndFox.Mouse[3];
        mice[0] = new MiceAndFox.Mouse(1, 9);
        mice[1] = new MiceAndFox.Mouse(2, 0);
        mice[2] = new MiceAndFox.Mouse(3, 2);

        int[] holePositions = new int[3];
        holePositions[0] = 4;
        holePositions[1] = 5;
        holePositions[2] = 7;

        miceAndFoxSolver.hide(holePositions, mice);

        Assertions.assertEquals(2, mice[0].getId());
        Assertions.assertEquals(4, mice[0].getPosition());

        Assertions.assertEquals(3, mice[1].getId());
        Assertions.assertEquals(5, mice[1].getPosition());

        Assertions.assertEquals(1, mice[2].getId());
        Assertions.assertEquals(7, mice[2].getPosition());
    }

    @Test
    public void hide_function_will_throw_null_pointer_exception_for_null_holes_positions_input() {
        MiceAndFox.Mouse[] mice = new MiceAndFox.Mouse[3];
        mice[0] = new MiceAndFox.Mouse(1, 9);
        mice[1] = new MiceAndFox.Mouse(2, 0);
        mice[2] = new MiceAndFox.Mouse(3, 2);

        try {
            miceAndFoxSolver.hide(null, mice);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void hide_function_will_throw_null_pointer_exception_for_null_mice_array() {
        int[] holePositions = new int[3];
        holePositions[0] = 4;
        holePositions[1] = 5;
        holePositions[2] = 7;

        try {
            miceAndFoxSolver.hide(holePositions, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void hide_function_will_throw_illegal_argument_exception_for_unequal_mice_and_holes_array_lengths() {
        try {
            miceAndFoxSolver.hide(new int[4], new MiceAndFox.Mouse[3]);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}
