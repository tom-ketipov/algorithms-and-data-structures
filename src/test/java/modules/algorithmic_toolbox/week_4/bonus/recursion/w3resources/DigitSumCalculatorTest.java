package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DigitSumCalculatorTest {
    private DigitSumCalculator digitSumCalculator;

    @BeforeEach
    public void setUp() {
        digitSumCalculator = new DigitSumCalculator();
    }

    @Test
    public void should_return_seven_for_the_sum_of_digits_in_twenty_five() {
        Assertions.assertEquals(7, digitSumCalculator.findDigitSum(25));
    }

    @Test
    public void should_return_seven_for_the_sum_of_digits_in_minus_twenty_five() {
        Assertions.assertEquals(7, digitSumCalculator.findDigitSum(-25));
    }

    @Test
    public void should_return_input_number_for_single_digit_inputs() {
        Assertions.assertEquals(5, digitSumCalculator.findDigitSum(5));
    }

    @Test
    public void should_return_one_for_the_sum_of_digits_in_ten() {
        Assertions.assertEquals(1, digitSumCalculator.findDigitSum(10));
    }
}