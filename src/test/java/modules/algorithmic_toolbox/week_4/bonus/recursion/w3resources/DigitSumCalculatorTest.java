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
    public void should_return_seven_for_twenty_five() {
        Assertions.assertEquals(7, digitSumCalculator.findDigitSum(25));
    }

    @Test
    public void should_return_seven_for_minus_twenty_five() {
        Assertions.assertEquals(7, digitSumCalculator.findDigitSum(-25));
    }

    @Test
    public void should_return_input_for_single_digit_numbers() {
        Assertions.assertEquals(5, digitSumCalculator.findDigitSum(5));
    }

    @Test
    public void should_return_one_for_ten() {
        Assertions.assertEquals(1, digitSumCalculator.findDigitSum(10));
    }
}