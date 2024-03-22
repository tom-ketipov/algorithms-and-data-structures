package modules.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges.HugeFibonacciNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HugeFibonacciNumberTest {

    private HugeFibonacciNumber hugeFibonacciNumberSolver;

    @BeforeEach
    void setUp() {
        hugeFibonacciNumberSolver = new HugeFibonacciNumber();
    }

    @Test
    public void can_find_remainder_for_mod_operation_bigger_than_the_fibonacci_number() {
        Assertions.assertEquals(2, hugeFibonacciNumberSolver.getFibonacciNumberMod(3, 150));
    }

    @Test
    public void can_find_remainder_for_mod_operation_equal_to_the_exact_fibonacci_number() {
        Assertions.assertEquals(0, hugeFibonacciNumberSolver.getFibonacciNumberMod(10, 55));
    }

    @Test
    public void can_find_remainder_for_mod_operation_equal_to_lower_boundary() {
        Assertions.assertEquals(1, hugeFibonacciNumberSolver.getFibonacciNumberMod(51010, 2));
    }

    @Test
    public void can_find_remainder_for_mod_operation_equal_to_upper_boundary() {
        Assertions.assertEquals(125, hugeFibonacciNumberSolver.getFibonacciNumberMod(500000, 1000));
    }

    @Test
    public void can_handle_invalid_lower_modulo_input_parameters() {
        int minAllowed = 2;
        int maxAllowed = 1000;

        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, 1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed), e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_modulo_input_parameters() {
        int minAllowed = 2;
        int maxAllowed = 1000;

        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, -131);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed), e.getMessage());
        }
    }

    @Test
    public void can_handle_invalid_higher_modulo_input_parameters() {
        int minAllowed = 2;
        int maxAllowed = 1000;

        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, 1001);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed), e.getMessage());
        }
    }

    @Test
    public void can_handle_invalid_index_input_parameters() {
        int minAllowed = 1;
        int maxAllowed = Integer.MAX_VALUE;

        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(-1, 100);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed), e.getMessage());
        }
    }
}