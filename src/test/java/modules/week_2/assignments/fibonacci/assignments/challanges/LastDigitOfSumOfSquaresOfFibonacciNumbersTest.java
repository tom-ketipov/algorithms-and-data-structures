package modules.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.fibonacci.LastDigitOfSumOfSquaresOfFibonacciNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LastDigitOfSumOfSquaresOfFibonacciNumbersTest {

    private LastDigitOfSumOfSquaresOfFibonacciNumbers lastDigitOfSumOfSquaresOfFibonacciNumbersSolver;

    @BeforeEach
    void setUp() {
        lastDigitOfSumOfSquaresOfFibonacciNumbersSolver = new LastDigitOfSumOfSquaresOfFibonacciNumbers();
    }

    @Test
    public void can_find_last_digit_of_sum_of_squares_of_fibonacci_numbers_for_first_number_in_the_sequence() {
        Assertions.assertEquals(1, lastDigitOfSumOfSquaresOfFibonacciNumbersSolver.findPartialSumOfFibonacciNumbersLastDigits(1));
    }

    @Test
    public void can_find_last_digit_of_sum_of_squares_of_fibonacci_numbers_for_multiple_numbers_in_the_sequence() {
        Assertions.assertEquals(5, lastDigitOfSumOfSquaresOfFibonacciNumbersSolver.findPartialSumOfFibonacciNumbersLastDigits(10));
    }

    @Test
    public void can_handle_negative_index_input_in_the_last_digit_of_sum_of_squares_method() {
        try {
            lastDigitOfSumOfSquaresOfFibonacciNumbersSolver.findPartialSumOfFibonacciNumbersLastDigits(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}