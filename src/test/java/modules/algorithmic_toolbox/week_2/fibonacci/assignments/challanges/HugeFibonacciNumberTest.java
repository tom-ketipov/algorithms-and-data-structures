package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, 1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The value must be between 2 and 1,000.", e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_modulo_input_parameters() {
        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, -131);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The value must be between 2 and 1,000.", e.getMessage());
        }
    }

    @Test
    public void can_handle_invalid_higher_modulo_input_parameters() {
        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(10, 1001);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The value must be between 2 and 1,000.", e.getMessage());
        }
    }

    @Test
    public void can_handle_invalid_index_input_parameters() {
        try {
            hugeFibonacciNumberSolver.getFibonacciNumberMod(-1, 1001);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The value must be between 1 and 2,147,483,647.", e.getMessage());
        }
    }
}