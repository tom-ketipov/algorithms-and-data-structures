package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DigitCounterTest {

    private DigitCounter digitCounter;

    @BeforeEach
    void setUp() {
        digitCounter = new DigitCounter();
    }

    @Test
    public void should_return_one_for_single_digit_positive_number() {
        Assertions.assertEquals(1, digitCounter.countTotalDigits(4));
    }

    @Test
    public void should_return_one_for_single_digit_negative_number() {
        Assertions.assertEquals(1, digitCounter.countTotalDigits(-2));
    }

    @Test
    public void should_return_ten_for_ten_digit_number() {
        Assertions.assertEquals(10, digitCounter.countTotalDigits(1028465728));
    }
}