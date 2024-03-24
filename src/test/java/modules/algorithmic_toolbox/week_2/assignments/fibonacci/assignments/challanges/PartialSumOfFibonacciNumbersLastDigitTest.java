package modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.fibonacci.PartialSumOfFibonacciNumbersLastDigit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void can_find_partial_sum_of_zero_fibonacci() {
        Assertions.assertEquals(0, partialSumOfFibonacciNumbersLastDigitSolver.findPartialSumOfFibonacciNumbersLastDigits(0));
    }

    @Test
    public void can_handle_negative_index_input_with_partial_sum_method() {
        try {
            partialSumOfFibonacciNumbersLastDigitSolver.findPartialSumOfFibonacciNumbersLastDigits(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}