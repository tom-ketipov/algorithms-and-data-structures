package modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges.LastDigitOfFibonacciNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LastDigitOfFibonacciNumberTest {
    private LastDigitOfFibonacciNumber lastDigitOfFibonacciNumberSolver;

    @BeforeEach
    void setUp() {
        lastDigitOfFibonacciNumberSolver = new LastDigitOfFibonacciNumber();
    }

    @Test
    public void can_extract_last_digit_of_single_digit_fibonacci_number() {
        Assertions.assertEquals(1, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(1));
    }

    @Test
    public void can_extract_last_digit_of_double_digit_fibonacci_number() {
        Assertions.assertEquals(5, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(10));
    }

    @Test
    public void can_extract_last_digit_of_zero_fibonacci_number() {
        Assertions.assertEquals(0, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(0));
    }

    @Test
    public void can_extract_last_digit_of_four_digit_fibonacci_number() {
        Assertions.assertEquals(5, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(20));
    }

    @Test
    public void can_extract_last_digit_of_twenty_one_digit_fibonacci_number() {
        Assertions.assertEquals(5, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(100));
    }

    @Test
    public void can_extract_last_digit_of_hundred_and_five_digit_fibonacci_number() {
        Assertions.assertEquals(5, lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(500));
    }

    @Test
    public void can_handle_negative_input_with_last_digit_function() {
        try {
            lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

}