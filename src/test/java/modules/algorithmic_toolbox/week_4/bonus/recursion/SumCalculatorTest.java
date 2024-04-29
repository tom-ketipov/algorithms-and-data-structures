package modules.algorithmic_toolbox.week_4.bonus.recursion;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    public void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    public void should_calculate_sum_accurately_for_upper_limit_higher_than_the_initial_value() {
        int upperLimit = 5;

        Assertions.assertEquals(15, sumCalculator.calculateSum(upperLimit));
    }

    @Test
    public void should_calculate_sum_accurately_for_upper_limit_equal_to_the_initial_value() {
        int upperLimit = 1;

        Assertions.assertEquals(1, sumCalculator.calculateSum(upperLimit));
    }

    @Test
    public void should_throw_illegal_argument_exception_for_zero_upper_limit() {
        int upperLimit = 0;

        try {
            sumCalculator.calculateSum(upperLimit);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));
        }
    }
}
