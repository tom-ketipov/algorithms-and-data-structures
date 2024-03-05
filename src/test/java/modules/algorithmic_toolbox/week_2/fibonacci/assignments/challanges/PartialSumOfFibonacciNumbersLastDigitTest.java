package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartialSumOfFibonacciNumbersLastDigitTest {

    private PartialSumOfFibonacciNumbersLastDigit partialSumOfFibonacciNumbersLastDigitSolver;

    @BeforeEach
    void setUp() {
        partialSumOfFibonacciNumbersLastDigitSolver = new PartialSumOfFibonacciNumbersLastDigit();
    }

    @Test
    public void can_find_partial_sum_of_single_digit_sum() {
        Assertions.assertEquals(1, partialSumOfFibonacciNumbersLastDigitSolver.findPartialSumOfFibonacciNumbersLastDigits(1));
    }

    @Test
    public void can_find_partial_sum_of_multiple_digits_sum() {
        Assertions.assertEquals(3, partialSumOfFibonacciNumbersLastDigitSolver.findPartialSumOfFibonacciNumbersLastDigits(10));
    }

    @Test
    public void can_handle_negative_index_input_with_partial_sum_method() {
        try {
            partialSumOfFibonacciNumbersLastDigitSolver.findPartialSumOfFibonacciNumbersLastDigits(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}