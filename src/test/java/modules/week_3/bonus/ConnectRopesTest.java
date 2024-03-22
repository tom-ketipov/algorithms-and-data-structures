package modules.week_3.bonus;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.bonus.ConnectRopes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectRopesTest {

    private ConnectRopes connectRopesSolver;

    @BeforeEach
    void setUp() {
        connectRopesSolver = new ConnectRopes();
    }

    @Test
    public void should_return_correct_total_cost_when_connecting_ropes_with_valid_lengths() {
        int[] ropeLengths = {2, 3, 4, 6};
        Assertions.assertEquals(29, connectRopesSolver.connect(ropeLengths));
    }

    @Test
    public void should_return_initial_rope_length_when_input_array_contains_single_rope() {
        int[] ropeLengths = {2};
        Assertions.assertEquals(2, connectRopesSolver.connect(ropeLengths));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input() {
        try {
            connectRopesSolver.connect(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void throws_illegal_argument_exception_for_negative_rope_length() {
        int[] ropeLengths = {-5, 3, 1, 6};

        try {
            connectRopesSolver.connect(ropeLengths);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void throws_illegal_argument_exception_for_zero_rope_length() {
        int[] ropeLengths = {0, 3, 1, 6};

        try {
            connectRopesSolver.connect(ropeLengths);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}