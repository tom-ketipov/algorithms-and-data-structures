package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumOfFibonacciNumbersLastDigitTest {

    private SumOfFibonacciNumbersLastDigit lastDigitOfFibonacciNumberSumSolver;

    @BeforeEach
    void setUp() {
        lastDigitOfFibonacciNumberSumSolver = new SumOfFibonacciNumbersLastDigit();
    }

    @Test
    public void can_calculate_sum_of_last_digits_for_first_number_in_fibonacci_sequence() {
        Assertions.assertEquals(1, lastDigitOfFibonacciNumberSumSolver.findSumOfFibonacciNumbersLastDigit(1));
    }

    @Test
    public void can_calculate_sum_of_last_digits_until_tenth_number_in_fibonacci_sequence() {
        Assertions.assertEquals(33, lastDigitOfFibonacciNumberSumSolver.findSumOfFibonacciNumbersLastDigit(10));
    }

    @Test
    public void can_handle_negative_index_input_parameters_with_last_digit_of_fibonacci_number_sum_method() {
        try {
            lastDigitOfFibonacciNumberSumSolver.findSumOfFibonacciNumbersLastDigit(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_index_input_parameters_with_last_digit_of_fibonacci_number_sum_method() {
        try {
            lastDigitOfFibonacciNumberSumSolver.findSumOfFibonacciNumbersLastDigit(0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}