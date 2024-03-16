package modules.algorithmic_toolbox.week_3;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyChangeTest {
    private MoneyChange moneyChangeSolver;

    @BeforeEach
    public void setUp() {
        moneyChangeSolver = new MoneyChange();
    }

    @Test
    public void calculate_minimum_coins_for_change_returns_correct_value_for_max_integer_input_value() {
        Assertions.assertEquals(214748367, moneyChangeSolver.calculateMinimumCoinsForChange(Integer.MAX_VALUE));
    }

    @Test
    public void calculate_minimum_coins_for_change_returns_correct_value_for_zero_input_value() {
        Assertions.assertEquals(0, moneyChangeSolver.calculateMinimumCoinsForChange(0));
    }

    @Test
    public void calculate_minimum_coins_for_change_returns_correct_value_for_one_as_input_value() {
        Assertions.assertEquals(1, moneyChangeSolver.calculateMinimumCoinsForChange(1));
    }

    @Test
    public void calculate_minimum_coins_for_change_returns_illegal_argument_exception_for_negative_input_value() {
        try {
            moneyChangeSolver.calculateMinimumCoinsForChange(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}
