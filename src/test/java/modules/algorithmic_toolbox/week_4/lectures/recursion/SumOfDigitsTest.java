package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {
    private SumOfDigits sumOfDigitsSolver;

    @BeforeEach
    public void setUp() {
        sumOfDigitsSolver = new SumOfDigits();
    }

    @Test
    public void can_calculate_sum_of_positive_number_digits_linearly() {
        int number = 1523;
        assertEquals(11, sumOfDigitsSolver.linearSum(number));
    }

    @Test
    public void can_calculate_sum_of_negative_number_digits_linearly() {
        int number = -1223;
        assertEquals(8, sumOfDigitsSolver.linearSum(number));
    }

    @Test
    public void can_calculate_sum_of_positive_number_digits_recursively() {
        int number = 1523;
        assertEquals(11, sumOfDigitsSolver.recursiveSum(number));
    }

    @Test
    public void can_calculate_sum_of_negative_number_digits_recursively() {
        int number = -1223;
        assertEquals(8, sumOfDigitsSolver.recursiveSum(number));
    }
}