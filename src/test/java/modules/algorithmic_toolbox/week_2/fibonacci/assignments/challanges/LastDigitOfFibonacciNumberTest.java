package modules.algorithmic_toolbox.week_2.fibonacci.assignments.challanges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class LastDigitOfFibonacciNumberTest {
    private LastDigitOfFibonacciNumber lastDigitOfFibonacciNumberSolver;

    @BeforeEach
    void setUp() {
        lastDigitOfFibonacciNumberSolver = new LastDigitOfFibonacciNumber();
    }

    @Test
    public void can_extract_last_digit_of_single_digit_fibonacci_number() {
        Assertions.assertEquals(lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(1), 1);
    }

    @Test
    public void can_extract_last_digit_of_double_digit_fibonacci_number() {
        Assertions.assertEquals(lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(10), 5);
    }

    @Test
    public void can_extract_last_digit_of_four_digit_fibonacci_number() {
        Assertions.assertEquals(lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(20), 5);
    }

    @Test
    public void can_extract_last_digit_of_twenty_one_digit_fibonacci_number() {
        Assertions.assertEquals(lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(100), 5);
    }

    @Test
    public void can_extract_last_digit_of_hundred_and_five_digit_fibonacci_number() {
        Assertions.assertEquals(lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(500), 5);
    }

    @Test
    public void can_handle_negative_input_with_last_digit_function() {
        try {
            lastDigitOfFibonacciNumberSolver.getLastFibonacciNumberDigit(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "The validated expression is false");
        }
    }

}