package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciSolverTest {

    private FibonacciSolver fibonacciSolver;

    @BeforeEach
    void setUp() {
        fibonacciSolver = new FibonacciSolver();
    }

    @Test
    public void should_return_one_for_first_fib_index() {
        Assertions.assertEquals(1, fibonacciSolver.findNthTerm(1));
    }

    @Test
    public void should_return_zero_for_zero_fib_index() {
        Assertions.assertEquals(0, fibonacciSolver.findNthTerm(0));
    }

    @Test
    public void should_return_fifty_five_for_tenth_fib_index() {
        Assertions.assertEquals(55, fibonacciSolver.findNthTerm(10));
    }

    @Test
    public void should_return_six_thousand_seven_hundred_and_sixty_five_for_twentieth_fib_index() {
        Assertions.assertEquals(6765, fibonacciSolver.findNthTerm(20));
    }

    @Test
    public void should_throw_illegal_argument_exception_for_negative_input() {
        try {
            fibonacciSolver.findNthTerm(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(fibonacciSolver.getLowerBoundary(), fibonacciSolver.getUpperBoundary()), e.getMessage());
        }
    }

    @Test
    public void should_throw_illegal_argument_exception_for_twenty_first_index() {
        try {
            fibonacciSolver.findNthTerm(21);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(fibonacciSolver.getLowerBoundary(), fibonacciSolver.getUpperBoundary()), e.getMessage());
        }
    }
}