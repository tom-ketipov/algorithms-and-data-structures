package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticSeriesSumTest {
    private ArithmeticSeriesSum arithmeticSeriesSum;

    @BeforeEach
    public void setUp() {
        arithmeticSeriesSum = new ArithmeticSeriesSum();
    }

    @Test
    public void can_calculate_arithmetic_series_sum_with_linear_function() {
        int n = 5;
        assertEquals(15, arithmeticSeriesSum.linearArithmeticSeriesSum(n));
    }

    @Test
    public void can_calculate_arithmetic_series_sum_with_recursive_function() {
        int n = 100;
        assertEquals(5050, arithmeticSeriesSum.recursiveArithmeticSeriesSum(n));
    }

    @Test
    public void recursive_function_throws_exception_for_negative_input() {
        try {
            arithmeticSeriesSum.recursiveArithmeticSeriesSum(-100);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }
}