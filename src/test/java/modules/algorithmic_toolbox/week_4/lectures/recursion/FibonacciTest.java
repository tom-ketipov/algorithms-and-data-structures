package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    private Fibonacci fibonacciSolver;

    @BeforeEach
    public void setUp() {
        fibonacciSolver = new Fibonacci();
    }

    @Test
    public void can_calculate_fibonacci_of_valid_positive_index() {
        int index = 10;
        assertEquals(55, fibonacciSolver.linearFibonacci(index));
    }

    @Test
    public void can_calculate_zero_fibonacci_index() {
        int index = 0;
        assertEquals(0, fibonacciSolver.linearFibonacci(index));
    }

    @Test
    public void can_calculate_first_fibonacci_index() {
        int index = 1;
        assertEquals(1, fibonacciSolver.linearFibonacci(index));
    }

    @Test
    public void throws_exception_for_negative_values() {
        int index = -12;
        try {
            fibonacciSolver.linearFibonacci(index);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_calculate_first_fibonacci_index_recursively() {
        int index = 10;
        assertEquals(55, fibonacciSolver.recursiveFibonacci(index));
    }
}