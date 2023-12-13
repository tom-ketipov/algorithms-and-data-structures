package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    private Factorial factorialSolver;

    @BeforeEach
    public void setUp() {
        factorialSolver = new Factorial();
    }

    @Test
    public void can_calculate_factorial_with_linear_function() {
        int n = 5;
        assertEquals(120, factorialSolver.linearFactorial(n));
    }

    @Test
    public void can_calculate_factorial_of_zero_with_linear_function() {
        int n = 0;
        assertEquals(1, factorialSolver.linearFactorial(n));
    }

    @Test
    public void can_calculate_factorial_with_recursive_function() {
        int n = 5;
        assertEquals(120, factorialSolver.recursiveFactorial(n));
    }

    @Test
    public void can_calculate_factorial_of_zero_with_recursive_function() {
        int n = 0;
        assertEquals(1, factorialSolver.recursiveFactorial(n));
    }

    @Test
    public void cant_calculate_factorial_for_negative_input_with_linear_function() {
        try {
            factorialSolver.linearFactorial(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}